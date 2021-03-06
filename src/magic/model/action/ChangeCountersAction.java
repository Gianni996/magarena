package magic.model.action;

import magic.model.MagicObject;
import magic.model.MagicCounterType;
import magic.model.MagicGame;
import magic.model.MagicPermanent;

public class ChangeCountersAction extends MagicAction {

    private final MagicObject obj;
    private final MagicCounterType counterType;
    private final int amount;
    private final boolean hasScore;

    private ChangeCountersAction(final MagicObject obj, final MagicCounterType counterType, final int amount, final boolean hasScore) {
        this.obj=obj;
        this.counterType=counterType;

        // number of counters cannot become negative
        this.amount = (obj.getCounters(counterType) + amount >= 0) ?
            amount : -obj.getCounters(counterType);

        this.hasScore=hasScore;
    }

    public static ChangeCountersAction Enters(final MagicPermanent permanent, final MagicCounterType counterType, final int amount) {
        return new ChangeCountersAction(permanent, counterType, amount, false);
    }

    public ChangeCountersAction(final MagicObject obj, final MagicCounterType counterType, final int amount) {
        this(obj, counterType, amount, true);
    }

    @Override
    public void doAction(final MagicGame game) {
        if (amount == 0) {
            return;
        }
        final int oldScore = hasScore && obj.isPermanent() ? ((MagicPermanent)obj).getScore() : 0;
        obj.changeCounters(counterType, amount);
        if (hasScore && obj.isPermanent()) {
            setScore(obj.getController(), ((MagicPermanent)obj).getScore() - oldScore);
        }
        game.setStateCheckRequired();
    }

    @Override
    public void undoAction(final MagicGame game) {
        obj.changeCounters(counterType, -amount);
    }
}
