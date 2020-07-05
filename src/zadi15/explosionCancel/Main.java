package zadi15.explosionCancel;

/*  
 *  Copyright https://github.com/zadi15
 *  
 *  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
	}

	@EventHandler
	public void onBlockBoom(BlockExplodeEvent event) throws InterruptedException {
		event.setCancelled(true);
		return;
	}
	
	@EventHandler
	public void onEntityBoom(EntityExplodeEvent event2) throws InterruptedException {
		event2.setCancelled(true);
		return;
	}
	
	@EventHandler
	public void onEnitityDamage(EntityDamageEvent event3) throws InterruptedException {
		if (event3.getCause().toString().equals("BLOCK_EXPLOSION") || event3.getCause().toString().equals("ENTITY_EXPLOSION")) {
			event3.setCancelled(true);
		}
	}
}