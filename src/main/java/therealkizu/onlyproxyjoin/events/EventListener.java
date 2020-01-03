/*
 * Copyright 2019-2020 TheRealKizu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package therealkizu.onlyproxyjoin.events;

import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerPreLoginEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPreLogin(PlayerPreLoginEvent e) {
        String notOnProxy = Server.getInstance().getConfig().getString("notOnProxy", "§cPlease join using the main server!").replace("§", "\u00A7").replace("%n", "\n");
        String mainServerAddress = Server.getInstance().getConfig().getString("mainServerAddress", "0.0.0.0");
        if (e.getPlayer().getAddress().equals(mainServerAddress)) {
            e.getPlayer().kick(notOnProxy);
        }
    }

}
