package me.runescapejon.CrazyFeet.Commands.head;

import java.util.ArrayList;
import java.util.Optional;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyMagicHeadCommand implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cMagicHead = CrazyFeet.crazyMagicHead;

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazymagichead")) {
				if (cMagicHead.contains(player)) {
					cMagicHead.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Magic Particles on your head"));
					return CommandResult.success();
				} else {
					cMagicHead.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your magic particles on your head"));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazymagicheadother")) {
			Player targ = target.get();

			if (cMagicHead.contains(targ)) {
				cMagicHead.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyMagicHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyMagicHead has been disabled!"));
				return CommandResult.success();
			} else {
				cMagicHead.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyMagicHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyMagicHead!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
