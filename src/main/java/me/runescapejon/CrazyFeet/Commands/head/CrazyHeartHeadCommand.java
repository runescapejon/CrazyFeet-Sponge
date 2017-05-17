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

public class CrazyHeartHeadCommand implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cHeartHead = CrazyFeet.crazyHeartHead;

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyfeet.crazyhearthead")) {
				if (cHeartHead.contains(player)) {
					cHeartHead.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your heart Particles on your head"));
					return CommandResult.success();
				} else {
					cHeartHead.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your heart particles on your head"));
					return CommandResult.success();
				}
			}
		}

		else if (src.hasPermission("CrazyFeet.crazyheartheadother")) {
			Player targ = target.get();

			if (cHeartHead.contains(targ)) {
				cHeartHead.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyHeartHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyHeartHead has been disabled!"));
				return CommandResult.success();
			} else {
				cHeartHead.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyHeartHead!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyHeartHead!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}