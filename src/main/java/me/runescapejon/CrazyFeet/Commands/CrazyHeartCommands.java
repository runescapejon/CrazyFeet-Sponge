package me.runescapejon.CrazyFeet.Commands;

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

public class CrazyHeartCommands implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cHeart = CrazyFeet.CrazyHeart;

		Optional<Player> target = args.<Player>getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazyheart")) {
				if (cHeart.contains(player)) {
					cHeart.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your heart Particles"));
					return CommandResult.success();
				} else {
					cHeart.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your heart particles"));
					return CommandResult.success();
				}
			}
		}

		else if (target.isPresent() && src.hasPermission("CrazyFeet.crazyheartother")) {
			Player targ = target.get();

			if (cHeart.contains(targ)) {
				cHeart.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyHeart!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyHeart has been disabled!"));
				return CommandResult.success();
			} else {
				cHeart.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyHeart!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyHeart!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
