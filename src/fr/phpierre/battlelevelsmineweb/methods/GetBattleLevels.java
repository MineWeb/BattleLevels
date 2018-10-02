package fr.phpierre.battlelevelsmineweb.methods;

import fr.vmarchaud.mineweb.common.ICore;
import fr.vmarchaud.mineweb.common.IMethod;
import fr.vmarchaud.mineweb.common.MethodHandler;
import me.robin.battlelevels.api.BattleLevelsAPI;
import me.robin.battlelevels.objects.BattlePlayer;

import java.util.ArrayList;
import java.util.Hashtable;

@MethodHandler
public class GetBattleLevels implements IMethod {

    @Override
    public Object execute(ICore instance, Object... inputs) {
        ArrayList<Hashtable> levels = new ArrayList<>();

        for(int i =0; i < BattleLevelsAPI.getTopScores().size(); i++){
            Hashtable<String, Object> l = new Hashtable<>();

            String player = BattleLevelsAPI.getTopScores().get(i).getKey();
            BattlePlayer b = BattleLevelsAPI.findPlayer(player);

            l.put("player", player);
            l.put("score", b.getScore());
            l.put("level", b.getLevel());
            l.put("kill", b.getKills());
            l.put("death", b.getDeaths());
            l.put("killstreak", b.getKillstreak());
            l.put("topstreak", b.getTopStreak());

            levels.add(l);
        }

        return levels;
    }

}
