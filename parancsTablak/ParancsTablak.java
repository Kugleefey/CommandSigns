package parancsTablak;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ParancsTablak extends JavaPlugin implements Listener {
	
	
	String prefix = ChatColor.AQUA + "«" + ChatColor.DARK_BLUE + "«" + ChatColor.BLUE + "Command" + ChatColor.WHITE + "Signs" + ChatColor.DARK_BLUE + "»" + ChatColor.AQUA + "»" + ChatColor.GOLD + " ";
	
	@SuppressWarnings("unchecked")
	List<String> parancsok = (List<String>) getConfig().getList("Commands");
		
	@Override
	public void onEnable(){
		
		//Alapértelmezett konfig mentése
		saveDefaultConfig();
		//Jobb klikkre hallgató esemény regisztrálása
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		
		if(cmd.getName().equalsIgnoreCase("csigns")){
			
			if(sender instanceof Player){
				
				if(sender.isOp()){
					
					//A hiba karakterlánc több helyen is használt lesz, ezért ide kértem le..
					String hiba = getConfig().getString("error");
					
					//Ha nincs megadva argumentum hajtódjon végre ez a rész:
					if(args.length < 1){
						
						sender.sendMessage(prefix + getConfig().getString("usage").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
						sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
					
					//Ha az argumentumok száma meghaladja a 2-t hajtódjon végre ez:
					}else if(args.length > 2){
						
						sender.sendMessage(prefix + getConfig().getString("usage").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
						sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");

					}else{
						
						//Letiltott parancs hozzáadása
						if(args[0].equalsIgnoreCase("add")){
							
							if(args.length == 2){
								
								if(!parancsok.contains(args[1])){
									
									parancsok.add(args[1]);

									getConfig().set("Commands", parancsok);
									
									saveConfig();
									
									reloadConfig();
									
									sender.sendMessage(prefix + ChatColor.GREEN + getConfig().getString("addedSuccessful").replace("[command]", ChatColor.DARK_GREEN + args[1] + ChatColor.GREEN).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
									
								}else{
									
									sender.sendMessage(prefix + ChatColor.RED + hiba +": " + ChatColor.DARK_RED + getConfig().getString("addingFailed").replace("[command]", ChatColor.RED + args[1] + ChatColor.DARK_RED).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
									
								}
								
							}else{
								
								sender.sendMessage(prefix + getConfig().getString("addNoWord").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
								
							}
						
						//Letiltott parancs eltávolítása
						}else if(args[0].equalsIgnoreCase("remove")){
							
							if(args.length == 2){
								
								if(parancsok.contains(args[1])){
									
									parancsok.remove(args[1]);

									getConfig().set("Commands", parancsok);
									
									saveConfig();
									
									reloadConfig();
									
									sender.sendMessage(prefix + ChatColor.GREEN + getConfig().getString("removedSuccessful").replace("[command]", ChatColor.DARK_GREEN + args[1] + ChatColor.GREEN).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
									
								}else{
									
									sender.sendMessage(prefix + ChatColor.RED + hiba + ": " + ChatColor.DARK_RED + getConfig().getString("removingFailed").replace("[command]", ChatColor.RED + args[1] + ChatColor.DARK_RED).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
									
								}
								
							}else{
								
								sender.sendMessage(prefix + getConfig().getString("removeNoWord").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
								
							}
						
						//Enélkül valamiért hibát dobott ki..
						}else if(args[0].equalsIgnoreCase("")){
							
							sender.sendMessage(prefix + getConfig().getString("usage").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
							sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
						
						//Letiltott parancsok listája
						}else if(args[0].equalsIgnoreCase("list")){
							
							sender.sendMessage(prefix + getConfig().getString("blockedCMDSList").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó") + " " + ChatColor.RED + parancsok.toString().replace("[", "").replace("]", "") + ChatColor.GOLD + ".");
							sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
							
						}else{
							
							sender.sendMessage(prefix + getConfig().getString("usage").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
							sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
							
						}
						
					}
					
				//Ha nem rendelkezünk Operátori jogokkal, akkor is le tudjuk kérni a letiltott parancsok listáját
				}else{
					
					if(!(args.length != 1)){
						
						if(args[0].equalsIgnoreCase("list")){
							
							sender.sendMessage(prefix + getConfig().getString("blockedCMDSList").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó") + " " + ChatColor.RED + parancsok.toString().replace("[", "").replace("]", "") + ChatColor.GOLD + ".");
							sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
							
						}else{
							
							sender.sendMessage(prefix + "/CSigns list" + ChatColor.GREEN + "   -   " + ChatColor.AQUA + "Letiltott parancsok listázása.");
							
						}
						
					}else{
						
						sender.sendMessage(prefix + "/CSigns list" + ChatColor.GREEN + "   -   " + ChatColor.AQUA + "Letiltott parancsok listázása.");
						
					}
					
				}
				
				
			//Ha konzolból írnánk be a parancsot..
			}else{
				
				String hiba = getConfig().getString("error");
				
				if(args.length < 1){
					
					sender.sendMessage(prefix + getConfig().getString("usage").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
					sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");

				}else if(args.length > 2){
					
					sender.sendMessage(prefix + getConfig().getString("usage").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
					sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");

				}else{
					
					if(args[0].equalsIgnoreCase("add")){
						
						if(args.length == 2){
							
							if(!parancsok.contains(args[1])){
								
								parancsok.add(args[1]);

								getConfig().set("Commands", parancsok);
								
								saveConfig();
								
								reloadConfig();
								
								sender.sendMessage(prefix + ChatColor.GREEN + getConfig().getString("addedSuccessful").replace("[command]", ChatColor.DARK_GREEN + args[1] + ChatColor.GREEN).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
								
							}else{
								
								sender.sendMessage(prefix + ChatColor.RED + hiba +": " + ChatColor.DARK_RED + getConfig().getString("addingFailed").replace("[command]", ChatColor.RED + args[1] + ChatColor.DARK_RED).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
								
							}
							
						}else{
							
							sender.sendMessage(prefix + getConfig().getString("addNoWord").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
							
						}
						
					}else if(args[0].equalsIgnoreCase("remove")){
						
						if(args.length == 2){
							
							if(parancsok.contains(args[1])){
								
								parancsok.remove(args[1]);

								getConfig().set("Commands", parancsok);
								
								saveConfig();
								
								reloadConfig();
								
								sender.sendMessage(prefix + ChatColor.GREEN + getConfig().getString("removedSuccessful").replace("[command]", ChatColor.DARK_GREEN + args[1] + ChatColor.GREEN).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
								
							}else{
								
								sender.sendMessage(prefix + ChatColor.RED + hiba + ": " + ChatColor.DARK_RED + getConfig().getString("removingFailed").replace("[command]", ChatColor.RED + args[1] + ChatColor.DARK_RED).replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
								
							}
							
						}else{
							
							sender.sendMessage(prefix + getConfig().getString("removeNoWord").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
							
						}
						
					}else if(args[0].equalsIgnoreCase("list")){
						
						sender.sendMessage(prefix + getConfig().getString("blockedCMDSList").replace("***", ":").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó") + " " + ChatColor.GOLD + parancsok.toString().replace("[", "").replace("]", "") + ChatColor.AQUA + ".");
						sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
						
					}else{
						
						sender.sendMessage(prefix + getConfig().getString("usage").replace("aaa", "á").replace("iii", "í").replace("eee", "é").replace("OoO", "ő").replace("ooo", "ó"));
						sender.sendMessage(prefix + ChatColor.GRAY + "Plugin created by" + ChatColor.ITALIC + " Kugleefey" + ChatColor.GRAY + ".");
						
					}
					
				}
				
				
			}
				
				
		}
		
		return false;
		
	}
	
	//Táblára jobb klikkelő esemény
	@EventHandler
	public void onSignRightClick(PlayerInteractEvent e){
				
		Block block = e.getClickedBlock();
		
		Player p = e.getPlayer();
		
		//Lekérdezzük az esemény milétét illetve, hogy a kocka típúsa Tábla-e
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && block.getState() instanceof Sign){
			
			Sign sign = (Sign) block.getState();
						
			String parancs = "";
			String arg0 = "";
			String arg1 = "";
			String arg2 = "";
			String cmd = "";
			
			//Sorok érzékelése
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
			
			//Szóközök számlálása a végén lévő opció számára
			int szokozp = parancs.replace(" ", "").length();
			int szokoza0 = arg0.replace(" ", "").length();
			int szokoza1 = arg1.replace(" ", "").length();
			int szokoza2 = arg2.replace(" ", "").length();
			int hossz = szokozp + szokoza0 + szokoza1 + szokoza2;
			String sor1 = sign.getLine(0);
			
			//Tartalmazza-e a tábla a kapcsos zárójeleket
			if(sor1.contains("[") && sor1.contains("]")){
				
				//Érzékeli, nem-e [Buy] tábla vagy hasonló
				if(!cmd.contains("§")){
					
					//Ha a parancs le van tiltva nem csinál semmit
					if(parancsok.contains(parancs)){}
									
					else{
						//Parancs lefuttatása
						p.chat("/" + cmd);
						
						//Egy opció, plugin pontosság ellenőrzésére
						if(p.isOp()){
							
							if(p.getGameMode().equals(GameMode.ADVENTURE)){
								
								p.sendMessage(prefix + ChatColor.GOLD + "A parancsban lévő karakterek száma (/ és szóköz nélkül): " + ChatColor.AQUA + hossz + ChatColor.GOLD + ". A parancs pedig " + ChatColor.GREEN + "/" + cmd + ChatColor.GOLD + " volt.");
							
							}
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}