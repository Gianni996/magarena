[
    new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            return new MagicEvent(
                cardOnStack,
                MagicTargetChoice.NEG_TARGET_LAND,
                MagicDestroyTargetPicker.Destroy,
                this,
                "Destroy target land\$, then SN deals damage to that land's controller "+
                "equal to the number of land cards in that player's graveyard."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetPermanent(game, {
                game.doAction(new MagicDestroyAction(it));
                final int amount = game.filterCards(it.getController(),MagicTargetFilterFactory.LAND_CARD_FROM_YOUR_GRAVEYARD).size();
                game.doAction(new MagicDealDamageAction(event.getSource(),it.getController(),amount));
                game.logAppendMessage(event.getPlayer()," ("+amount+")");
            });
        }
    }
]
