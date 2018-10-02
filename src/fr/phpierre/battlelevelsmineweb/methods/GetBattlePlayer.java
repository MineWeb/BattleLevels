package fr.phpierre.battlelevelsmineweb.methods;

import fr.vmarchaud.mineweb.common.ICore;
import fr.vmarchaud.mineweb.common.IMethod;
import fr.vmarchaud.mineweb.common.MethodHandler;
import me.robin.battlelevels.api.BattleLevelsAPI;
import me.robin.battlelevels.objects.BattlePlayer;

import java.util.ArrayList;
import java.util.Hashtable;

@MethodHandler(inputs = 1, types = {String.class})
public class GetBattlePlayer  implements IMethod {

    @Override
    public Object execute(ICore instance, Object... inputs) {
        ArrayList<Hashtable> stats = new ArrayList<>();

        String player = (String) inputs[0];
        BattlePlayer b = BattleLevelsAPI.findPlayer(player);

        Hashtable<String, Object> s = new Hashtable<>();
        try{
            s.put("uuid", b.getUUID());
            s.put("name", b.getName());
            s.put("kill", b.getKills());
            s.put("death", b.getDeaths());
            s.put("score", b.getScore());
            s.put("killstreak", b.getKillstreak());
            s.put("topstreak", b.getTopStreak());
            s.put("level", b.getLevel());
            s.put("bar", b.getBar());
            s.put("booster", b.getBooster());
            s.put("kdr", b.getKdr());
            s.put("progress", b.getProgressDouble());

            stats.add(s);
        }catch(Exception e){

        }

        return stats;
    }


}
