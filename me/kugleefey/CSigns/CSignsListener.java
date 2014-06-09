package me.kugleefey.CSigns;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;

public class CSignsListener implements Listener {

  //Esemény kezelő
	@EventHandler
	public void onRightClickToSign(PlayerInteractEvent e){
		
		//Az eseményt érintő block
		Block block = e.getClickedBlock();
		
		//Játékos változója
		Player p = e.getPlayer();
		
		//Kölcsönhatás oka illetve a block típusa
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && block.getState() instanceof Sign){
			
			//Block beállítása táblára
			Sign sign = (Sign) block.getState();
			
			//A majd lekért sorok tárolói
			String parancs = "";
			String arg0 = "";
			String arg1 = "";
			String arg2 = "";
			String cmd = "";
			
			//Tábla sorainak érzékelése, átláthatóan
			if(sign.getLine(0).isEmpty()==false){
				
				parancs = sign.getLine(0).replace("[", "").replace("]", "");
				cmd = parancs;
				if(sign.getLine(1).isEmpty()==false){
					
					arg0 = sign.getLine(1);
					
					cmd = parancs + " " + arg0;
					
					if(sign.getLine(2).isEmpty()==false){
						
						arg1 = sign.getLine(2);
						cmd = parancs + " " + arg0 + " " + arg1;
						
						if(sign.getLine(3).isEmpty()==false){
							
							arg2 = sign.getLine(3);
							cmd = parancs + " " + arg0 + " " + arg1 + " " + arg2;
							
						}
						
					}
					
				}
				
			}
			
			//Szóközök számolása a végén lévő opció számára...
			int szokozp = parancs.replace(" ", "").length();
			int szokoza0 = arg0.replace(" ", "").length();
			int szokoza1 = arg1.replace(" ", "").length();
			int szokoza2 = arg2.replace(" ", "").length();
			int hossz = szokozp + szokoza0 + szokoza1 + szokoza2;
		
			String sor1 = sign.getLine(0);
			//Érzékeli a kapcsoszárójeleket
			if(sor1.contains("[") && sor1.contains("]")){
				
				//Kizárja a többi plugin által vezértelt táblákkal való összeakadást..
				if(!cmd.contains("§")){
				
					//Parancsok letiltása következik
					if(parancs.equalsIgnoreCase("tell")){}
					
					else if(parancs.equalsIgnoreCase("w")){}
					
					else if(parancs.equalsIgnoreCase("m")){}
					
					else if(parancs.equalsIgnoreCase("t")){}
					
					else if(parancs.equalsIgnoreCase("etell")){}
					
					else if(parancs.equalsIgnoreCase("whisper")){}
					
					else if(parancs.equalsIgnoreCase("ewhisper")){}
					
					else if(parancs.equalsIgnoreCase("mail")){}
					
					else if(parancs.equalsIgnoreCase("email")){}
					
					else if(parancs.equalsIgnoreCase("msg")){}
					
					else if(parancs.equalsIgnoreCase("emsg")){}
					
					else if(parancs.equalsIgnoreCase("warp")){}
					
					else if(parancs.equalsIgnoreCase("warps")){}
					
					else if(parancs.equalsIgnoreCase("ewarp")){}
					
					else if(parancs.equalsIgnoreCase("ewarps")){}
					
					else if(parancs.equalsIgnoreCase("kit")){}
					
					else if(parancs.equalsIgnoreCase("kits")){}
					
					else if(parancs.equalsIgnoreCase("ekit")){}
					
					else if(parancs.equalsIgnoreCase("ekits")){}
					
					else if(parancs.equalsIgnoreCase("heal")){}
					
					else if(parancs.equalsIgnoreCase("mob")){}
					
					else if(parancs.equalsIgnoreCase("spawnmob")){}
					
					else if(parancs.equalsIgnoreCase("emob")){}
					
					else if(parancs.equalsIgnoreCase("espawnmob")){}
					
					else if(parancs.equalsIgnoreCase("spawnentity")){}
					
					else if(parancs.equalsIgnoreCase("espawnentity")){}
					
					else if(parancs.equalsIgnoreCase("jump")){}
					
					else if(parancs.equalsIgnoreCase("ejump")){}
					
					else if(parancs.equalsIgnoreCase("j")){}
					
					else if(parancs.equalsIgnoreCase("ej")){}
					
					else if(parancs.equalsIgnoreCase("jumpto")){}
					
					else if(parancs.equalsIgnoreCase("ejumpto")){}
					
					else if(parancs.equalsIgnoreCase("eheal")){}
					
					else if(parancs.equalsIgnoreCase("lightning")){}
					
					else if(parancs.equalsIgnoreCase("elightning")){}
					
					else if(parancs.equalsIgnoreCase("shock")){}
					
					else if(parancs.equalsIgnoreCase("eshock")){}
					
					else if(parancs.equalsIgnoreCase("smite")){}
					
					else if(parancs.equalsIgnoreCase("esmite")){}
					
					else if(parancs.equalsIgnoreCase("strike")){}
					
					else if(parancs.equalsIgnoreCase("estrike")){}
					
					else if(parancs.equalsIgnoreCase("thor")){}
					
					else if(parancs.equalsIgnoreCase("ethor")){}
					
					else if(parancs.equalsIgnoreCase("mute")){}
					
					else if(parancs.equalsIgnoreCase("emute")){}
					
					else if(parancs.equalsIgnoreCase("silence")){}
					
					else if(parancs.equalsIgnoreCase("esilence")){}
					
					else if(parancs.equalsIgnoreCase("kick")){}
					
					else if(parancs.equalsIgnoreCase("ekick")){}
					
					else if(parancs.equalsIgnoreCase("gamemode")){}
					
					else if(parancs.equalsIgnoreCase("gm")){}
					
					else if(parancs.equalsIgnoreCase("adventure")){}
					
					else if(parancs.equalsIgnoreCase("eadventure")){}
					
					else if(parancs.equalsIgnoreCase("adventuremode")){}
					
					else if(parancs.equalsIgnoreCase("eadventuremode")){}
					
					else if(parancs.equalsIgnoreCase("creative")){}
					
					else if(parancs.equalsIgnoreCase("ecreative")){}
					
					else if(parancs.equalsIgnoreCase("creativemode")){}
					
					else if(parancs.equalsIgnoreCase("ecreativemode")){}
					
					else if(parancs.equalsIgnoreCase("egamemode")){}
					
					else if(parancs.equalsIgnoreCase("egm")){}
					
					else if(parancs.equalsIgnoreCase("gma")){}
					
					else if(parancs.equalsIgnoreCase("egma")){}
					
					else if(parancs.equalsIgnoreCase("gmc")){}
					
					else if(parancs.equalsIgnoreCase("egmc")){}
					
					else if(parancs.equalsIgnoreCase("egms")){}
					
					else if(parancs.equalsIgnoreCase("gms")){}
					
					else if(parancs.equalsIgnoreCase("gmt")){}
					
					else if(parancs.equalsIgnoreCase("egmt")){}
					
					else if(parancs.equalsIgnoreCase("survival")){}
					
					else if(parancs.equalsIgnoreCase("esurvival")){}
					
					else if(parancs.equalsIgnoreCase("survivalmode")){}
					
					else if(parancs.equalsIgnoreCase("esurvivalmode")){}
					
					else if(parancs.equalsIgnoreCase("sell")){}
					
					else if(parancs.equalsIgnoreCase("esell")){}
					
					else if(parancs.equalsIgnoreCase("info")){}
					
					else if(parancs.equalsIgnoreCase("about")){}
					
					else if(parancs.equalsIgnoreCase("eabout")){}
					
					else if(parancs.equalsIgnoreCase("ifo")){}
					
					else if(parancs.equalsIgnoreCase("eifo")){}
					
					else if(parancs.equalsIgnoreCase("einfo")){}
					
					else if(parancs.equalsIgnoreCase("inform")){}
					
					else if(parancs.equalsIgnoreCase("einform")){}
					
					else if(parancs.equalsIgnoreCase("news")){}
					
					else if(parancs.equalsIgnoreCase("enews")){}
					
					else if(parancs.equalsIgnoreCase("helpop")){}
					
					else if(parancs.equalsIgnoreCase("ac")){}
					
					else if(parancs.equalsIgnoreCase("eac")){}
					
					else if(parancs.equalsIgnoreCase("ehelpop")){}
					
					else if(parancs.equalsIgnoreCase("amsg")){}
					
					else if(parancs.equalsIgnoreCase("eamsg")){}
					
					else if(parancs.equalsIgnoreCase("repair")){}
					
					else if(parancs.equalsIgnoreCase("erepair")){}
					
					else if(parancs.equalsIgnoreCase("fix")){}
					
					else if(parancs.equalsIgnoreCase("efix")){}
					
					else if(parancs.equalsIgnoreCase("weather")){}
					
					else if(parancs.equalsIgnoreCase("eweather")){}
					
					else if(parancs.equalsIgnoreCase("rain")){}
					
					else if(parancs.equalsIgnoreCase("erain")){}
					
					else if(parancs.equalsIgnoreCase("sky")){}
					
					else if(parancs.equalsIgnoreCase("esky")){}
					
					else if(parancs.equalsIgnoreCase("storm")){}
					
					else if(parancs.equalsIgnoreCase("estorm")){}
					
					else if(parancs.equalsIgnoreCase("sun")){}
					
					else if(parancs.equalsIgnoreCase("esun")){}
					
					else if(parancs.equalsIgnoreCase("v")){}
					
					else if(parancs.equalsIgnoreCase("ev")){}
					
					else if(parancs.equalsIgnoreCase("vanish")){}
					
					else if(parancs.equalsIgnoreCase("evanish")){}
					
					else if(parancs.equalsIgnoreCase("setwarp")){}
					
					else if(parancs.equalsIgnoreCase("esetwarp")){}
					
					else if(parancs.equalsIgnoreCase("createwarp")){}
					
					else if(parancs.equalsIgnoreCase("ecreatewarp")){}
					
					else if(parancs.equalsIgnoreCase("sethome")){}
					
					else if(parancs.equalsIgnoreCase("esethome")){}
					
					else if(parancs.equalsIgnoreCase("createhome")){}
					
					else if(parancs.equalsIgnoreCase("ecreatehome")){}
					
					else if(parancs.equalsIgnoreCase("thunder")){}
					
					else if(parancs.equalsIgnoreCase("ethunder")){}
					
					else if(parancs.equalsIgnoreCase("tp")){}
					
					else if(parancs.equalsIgnoreCase("tele")){}
					
					else if(parancs.equalsIgnoreCase("etele")){}
					
					else if(parancs.equalsIgnoreCase("teleport")){}
					
					else if(parancs.equalsIgnoreCase("eteleport")){}
					
					else if(parancs.equalsIgnoreCase("etp")){}
					
					else if(parancs.equalsIgnoreCase("tp2p")){}
					
					else if(parancs.equalsIgnoreCase("etp2p")){}
					
					else if(parancs.equalsIgnoreCase("tpa")){}
					
					else if(parancs.equalsIgnoreCase("call")){}
					
					else if(parancs.equalsIgnoreCase("etpa")){}
					
					else if(parancs.equalsIgnoreCase("ecall")){}
					
					else if(parancs.equalsIgnoreCase("tpask")){}
					
					else if(parancs.equalsIgnoreCase("etpask")){}
					
					else if(parancs.equalsIgnoreCase("tpaccept")){}
					
					else if(parancs.equalsIgnoreCase("etpaccept")){}
					
					else if(parancs.equalsIgnoreCase("tpyes")){}
					
					else if(parancs.equalsIgnoreCase("etpyes")){}
					
					else if(parancs.equalsIgnoreCase("tpno")){}
					
					else if(parancs.equalsIgnoreCase("tpdeny")){}
					
					else if(parancs.equalsIgnoreCase("etpno")){}
					
					else if(parancs.equalsIgnoreCase("etpyes")){}
					
					else if(parancs.equalsIgnoreCase("tpahere")){}
					
					else if(parancs.equalsIgnoreCase("etpahere")){}
					
					else if(parancs.equalsIgnoreCase("tphere")){}
					
					else if(parancs.equalsIgnoreCase("etphere")){}
					
					else if(parancs.equalsIgnoreCase("s")){}
					
					else if(parancs.equalsIgnoreCase("fireball")){}
					
					else if(parancs.equalsIgnoreCase("fireskull")){}
					
					else if(parancs.equalsIgnoreCase("fireentity")){}
					
					//Parancs végrehajtása..
					else{
						
						p.chat("/" + cmd);
						//Innentől egy opciónális lehetőség annak érdekében, hogy lásd mit is csináltál pontosan
						if(p.isOp()){
							
							if(p.getGameMode() == GameMode.ADVENTURE){
								
								p.sendMessage(ChatColor.GOLD + "A parancsban lévő karakterek száma (/ és szóköz nélkül): " + ChatColor.AQUA + hossz + ChatColor.GOLD + ". A parancs pedig " + ChatColor.GREEN + "/" + cmd + ChatColor.GOLD + " volt.");
							
							}
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
