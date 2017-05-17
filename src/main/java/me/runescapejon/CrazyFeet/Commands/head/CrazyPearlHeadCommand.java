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

public class CrazyPearlHeadCommand implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cPearlHead = CrazyFeet.crazyPearlHead;

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazypearlhead")) {
				if (cPearlHead.contains(player)) {
					cPearlHead.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Pearl Particles on your head"));
					return CommandResult.success();
				} else {
					cPearlHead.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your Pearl particles on your head"));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazypearlheadother")) {
			Player targ = target.get();

			if (cPearlHead.contains(targ)) {
				cPearlHead.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyPearlHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyPearlHead has been disabled!"));
				return CommandResult.success();
			} else {
				cPearlHead.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyPearlHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyPearlHead!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
