package magic.model.target;

import magic.model.ARG;
import magic.model.MagicCounterType;
import magic.model.MagicAbility;
import magic.model.target.MagicTargetFilterFactory;
import magic.model.target.MagicTargetFilterFactory.Control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MagicTargetFilterParser {
            
    PermanentCardGraveyard(ARG.WORDRUN + " permanent card from your graveyard") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Graveyard);
        }
    },
    CreatureCardGraveyard(ARG.WORDRUN + " creature card from your graveyard") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreatureCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Graveyard);
        }
    },
    CardFromGraveyard(ARG.WORDRUN + " card from your graveyard") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Graveyard);
        }
    },
    PermanentCardOppGraveyard(ARG.WORDRUN + " permanent card from an opponent's graveyard") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.OpponentsGraveyard);
        }
    },
    CreatureCardOppGraveyard(ARG.WORDRUN + " creature card from an opponent's graveyard") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreatureCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.OpponentsGraveyard);
        }

    },
    CardFromOppGraveyard(ARG.WORDRUN + " card from an opponent's graveyard") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.OpponentsGraveyard);
        }
    },
    PermanentCardHand(ARG.WORDRUN + " permanent card from your hand") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Hand);
        }
    },
    CreatureCardHand(ARG.WORDRUN + " creature card from your hand") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreatureCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Hand);
        }
    },
    CardFromHand(ARG.WORDRUN + " card from your hand") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Hand);
        }
    },
    PermanentCardLibrary(ARG.WORDRUN + " permanent card from your library") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Library);
        }
    },
    CreatureCardLibrary(ARG.WORDRUN + " creature card from your library") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreatureCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Library);
        }
    },
    CardLibrary(ARG.WORDRUN + " card from your library") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCardPrefix(arg.group(), ARG.wordrun(arg), MagicTargetType.Library);
        }
    },
    CreatureYouControl(ARG.WORDRUN + " creature you control") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreaturePrefix(arg.group(), ARG.wordrun(arg), Control.You);
        }
    },
    CreatureOppControl(ARG.WORDRUN + " creature an opponent controls") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreaturePrefix(arg.group(), ARG.wordrun(arg), Control.Opp);
        }
    },
    Creature(ARG.WORDRUN + " creature") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchCreaturePrefix(arg.group(), ARG.wordrun(arg), Control.Any);
        }
    },
    Spell(ARG.WORDRUN + " spell") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchSpellPrefix(arg.group(), ARG.wordrun(arg));
        }
    },
    PermanentYouControl(ARG.WORDRUN + " permanent you control") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.You);
        }
    },
    PermanentOppControl(ARG.WORDRUN + " permanent an opponent controls") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.Opp);
        }
    },
    PermanentOppControl2(ARG.WORDRUN + " permanent you don't control") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.Opp);
        }
    },
    PermanentYouControl2(ARG.WORDRUN + " you control") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.You);
        }
    },
    PermanentOppControl3(ARG.WORDRUN + " an opponent controls") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.Opp);
        }
    },
    PermanentOppControl4(ARG.WORDRUN + " you don't control") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.Opp);
        }
    },
    Permanent(ARG.WORDRUN + " permanent") {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.Any);
        }
    },
    Permanent2(ARG.WORDRUN) {
        public MagicTargetFilter<?> toTargetFilter(final Matcher arg) {
            return MagicTargetFilterFactory.matchPermanentPrefix(arg.group(), ARG.wordrun(arg), Control.Any);
        }
    },
    ;
    
    private final Pattern pattern;
    
    private MagicTargetFilterParser(final String regex) {
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }
    public Matcher matcher(final String rule) {
        return pattern.matcher(rule);
    }

    public abstract MagicTargetFilter<?> toTargetFilter(final Matcher arg);
    
    public static final MagicTargetFilter<?> build(final String text) {
        for (final MagicTargetFilterParser rule : values()) {
            final Matcher matcher = rule.matcher(text);
            if (matcher.matches()) {
                return rule.toTargetFilter(matcher);
            }
        }
        throw new RuntimeException("unknown target filter \"" + text + "\"");
    }
}
