package de.exfy.chatfilter.antispam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import de.exfy.chatfilter.ChatFilter;
import net.md_5.bungee.api.scheduler.TaskScheduler;

public class AntiSpam {
	
	private Map<String, String> lastMessage;
	private List<String> playerCooldown;
	private ChatFilter plugin;
	
	private final int COOLDOWN_DELAY_SECONDS = 1;
	private final int COOLDOWN_REPEAT_SECONDS = 10;
	
	private static AntiSpam instance;
	
	private TaskScheduler ts;
	
	public AntiSpam(TaskScheduler ts) {
		this.lastMessage = new HashMap<>();
		this.playerCooldown = new ArrayList<>();
		this.ts = ts;
		this.plugin = ChatFilter.getInstance();
		instance = this;
	}
	
	public enum SpamType {
		DELAY, REPEAT, NONE
	}
	
	public Map<String, String> getLastMessages() {
		return lastMessage;
	}
	
	public List<String> getPlayerCooldown() {
		return playerCooldown;
	}
	
	public SpamType getSpam(String UUID, String message) {
		
		if(playerCooldown.contains(UUID)) {
			return SpamType.DELAY;
		}
		
		if(lastMessage.containsKey(UUID)) {
			if(lastMessage.get(UUID).equalsIgnoreCase(message)) {
				return SpamType.REPEAT;
			}
		}
		
		playerCooldown.add(UUID);
		lastMessage.put(UUID, message);
		
		ts.schedule(plugin, new MessageCooldown(UUID, SpamType.DELAY), COOLDOWN_DELAY_SECONDS, TimeUnit.SECONDS);
		ts.schedule(plugin, new MessageCooldown(UUID, SpamType.REPEAT), COOLDOWN_REPEAT_SECONDS, TimeUnit.SECONDS);
		
		return SpamType.NONE;
		
	}
	
	public static AntiSpam getInstance() {
		return instance;
	}
	

}
