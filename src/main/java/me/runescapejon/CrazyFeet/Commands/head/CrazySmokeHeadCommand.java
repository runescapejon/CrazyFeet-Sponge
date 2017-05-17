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

public class CrazySmokeHeadCommand implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cSmokeHead = CrazyFeet.crazySmokeHead;

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazysmokehead")) {
				if (cSmokeHead.contains(player)) {
					cSmokeHead.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Smoke Particles on your head"));
					return CommandResult.success();
				} else {
					cSmokeHead.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your Smoke particles on your head"));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazysmokeheadother")) {
			Player targ = target.get();

			if (cSmokeHead.contains(targ)) {
				cSmokeHead.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazySmokeHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazySmokeHead has been disabled!"));
				return CommandResult.success();
			} else {
				cSmokeHead.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazySmokeHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazySmokeHead!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}