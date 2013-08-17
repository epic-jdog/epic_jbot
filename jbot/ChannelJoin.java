package jbot;

import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ActionEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.ChannelInfoEvent;




public class ChannelJoin extends ListenerAdapter implements Listener {
	
	@Override
	public void onMessage(MessageEvent event) throws Exception {

	
	
		String channelraw = "#p_slice";
	
	
		if (event.getMessage().startsWith("!jbot join")){
			channelraw = event.getMessage().toString(); 
			//System.out.println(channelraw);
			
			
			String delims = "[ ]";
			String[] parts = channelraw.split(delims);
			
			String channeltojoin = parts[2];
  
			System.out.println(channeltojoin);  
			
			try {
				
				event.getBot().joinChannel(channeltojoin);
				
				}
				catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("IT DONE GOOFT ON JOINING ANOTHER CHANNEL!!");
				}
	
				String channelrawleave = null;
			if (event.getMessage().startsWith("!jbot leave")){
				channelrawleave = event.getMessage().toString(); 
				
			
				String[] partsleave = channelrawleave.split(delims);
				
				String channeltoleave = partsleave[2];
				System.out.println(channeltoleave);  
				event.getBot().partChannel(event.getBot().getChannel(channeltoleave), "Duty calls.");
		
		
		}
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	}