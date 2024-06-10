package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public Player findByName(String name) {
        for (String playerName : players.keySet()) {
            if (playerName.equals(name)) {
                return players.get(playerName);
            }
        }

        return null;
    }

    public void register(Player player) {
        if (!players.containsValue(player)) {
            players.put(player.getName(), player);
        }
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException(
                    "One of players is not registered."
            );
        }


        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else return 0;

    }
}
