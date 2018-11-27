package de.exfy.chatfilter;

import java.util.Collection;

import de.exfy.bungee.ExfyTwoBungee;
import de.exfy.chatfilter.antispam.AntiSpam;
import de.exfy.chatfilter.antispam.AntiSpam.SpamType;
import de.exfy.chatfilter.filter.FilterHit;
import de.exfy.chatfilter.filter.FilterManager;
import de.exfy.chatfilter.filter.badWord.BadWordFilter;
import de.exfy.chatfilter.filter.variations.LeetSpeakVariationProvider;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class ChatFilter extends Plugin implements Listener {
	
	private static ChatFilter instance;
	private AntiSpam antiSpam;
	
    @Override
    public void onEnable() {
    	
    		instance = this;
		
		antiSpam = new AntiSpam(getProxy().getScheduler());
    	
        FilterManager.INSTANCE.addFilter(new BadWordFilter());

        FilterManager.INSTANCE.variationManager.addVariationProvider(new LeetSpeakVariationProvider());

        ProxyServer.getInstance().getPluginManager().registerListener(this, this);
    }
    
    public static ChatFilter getInstance() {
		return instance;
	}

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerChat(ChatEvent e) {
        if (e.isCommand())
            return;
        
        if(e.getSender() instanceof ProxiedPlayer) {
        	
	    		ProxiedPlayer p = (ProxiedPlayer) e.getSender();

	    		SpamType type = antiSpam.getSpam(p.getUniqueId().toString(), e.getMessage().trim());

	    		if(!p.hasPermission("exfy.chatfilter")){
	    		    if(type == SpamType.DELAY) {
                        p.sendMessage(ExfyTwoBungee.getPrefix() + "§cNicht so schnell!");
                        e.setCancelled(true);
                        return;
                    } else if(type == SpamType.REPEAT) {
                        p.sendMessage(ExfyTwoBungee.getPrefix() + "§cBitte wiederhole dich nicht!");
                        e.setCancelled(true);
                        return;
                    }
                }
	    		
	    }

        String orginalMessage = e.getMessage().trim();
        String msg = e.getMessage().toLowerCase();

        Collection<FilterHit> hits = FilterManager.INSTANCE.scan(msg);

        for (FilterHit hit : hits) {
            String before = orginalMessage.substring(0, hit.getStart());
            String after = orginalMessage.substring(hit.getStart() + hit.getLength());
            orginalMessage = before + new String(new char[hit.getLength()]).replace("\0", "*") + after;
        }

        StringBuffer newMessage = new StringBuffer();

        orginalMessage.chars().forEach(chars -> {
            if(!(chars > 1000)) {
                System.out.println(chars);
                newMessage.append((char)chars);
            }
        });

        e.setMessage(newMessage.toString());

        /*if (!hits.isEmpty()) {
            ((ProxiedPlayer) e.getSender()).sendMessage(ExfyTwoBungee.getPrefix() + "§cDu darfst dieses Wort nicht benutzen!");
            e.setCancelled(true);
        }*/

    }

    private static String replaceUmlaut(String input) {

        //replace all lower Umlauts
        String output = input.replace("ü", "ue")
                .replace("ö", "oe")
                .replace("ä", "ae")
                .replace("ß", "ss");

        //first replace all capital umlaute in a non-capitalized context (e.g. Übung)
        output = output.replace("Ü(?=[a-zäöüß ])", "Ue")
                .replace("Ö(?=[a-zäöüß ])", "Oe")
                .replace("Ä(?=[a-zäöüß ])", "Ae");

        //now replace all the other capital umlaute
        output = output.replace("Ü", "UE")
                .replace("Ö", "OE")
                .replace("Ä", "AE");

        return output;
    }

    private static String replaceUmlautBack(String input) {

        //replace all lower Umlauts
        String output = input.replace("ue", "ü")
                .replace("oe", "ö")
                .replace("ae", "ä")
                .replace("ss", "ß");

        //first replace all capital umlaute in a non-capitalized context (e.g. Übung)
        output = output.replace("Ue", "Ü")
                .replace("Oe", "Ö")
                .replace("Ae", "Ä");

        //now replace all the other capital umlaute
        output = output.replace("UE", "Ü")
                .replace("OE", "Ö")
                .replace("AE", "Ä");

        return output;
    }
}
