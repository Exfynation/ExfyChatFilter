package de.exfy.chatfilter.antispam;

import de.exfy.chatfilter.antispam.AntiSpam.SpamType;

public class MessageCooldown implements Runnable {
	
	private SpamType type;
	private String UUID;
	
	public MessageCooldown(String UUID, SpamType type) {
		this.type = type;
		this.UUID = UUID;
	}

	@Override
	public void run() {
		
		if(type == SpamType.DELAY) {
			AntiSpam.getInstance().getPlayerCooldown().remove(UUID);
		} else if(type == SpamType.REPEAT) {
			AntiSpam.getInstance().getLastMessages().remove(UUID);
		}
		
	}

}
