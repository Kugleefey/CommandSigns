package me.kugleefey.CSigns;

import org.bukkit.plugin.java.JavaPlugin;

public class CSigns extends JavaPlugin {

	@Override
	public void onEnable(){
		//A táblára jobb klikkelő esemény regisztálása...
		getServer().getPluginManager().registerEvents(new CSignsListener(), this);
		
	}
	
}
