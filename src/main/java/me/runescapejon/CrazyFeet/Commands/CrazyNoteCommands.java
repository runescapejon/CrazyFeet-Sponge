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

public class CrazyNoteCommands implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<Player> cNote = CrazyFeet.Crazynote;

		Optional<Player> target = args.<Player>getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazynote")) {
				if (cNote.contains(player)) {
					cNote.remove(player);
					player.sendMessage(
							Text.of(TextColors.GOLD, player.getName(), " You have disabled your Note Particles"));
					return CommandResult.success();
				} else {
					cNote.add(player);
					player.sendMessage(Text.of(TextColors.GOLD, player.getName(), TextColors.AQUA,
							" You have enabled your Note particles"));
					return CommandResult.success();
				}
			}
		} else if (target.isPresent() && src.hasPermission("CrazyFeet.crazynoteother")) {
			Player targ = target.get();

			if (cNote.contains(targ)) {
				cNote.remove(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " has disabled your CrazyNote!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + "'s CrazyNote has been disabled!"));
				return CommandResult.success();
			} else {
				cNote.add(targ);
				targ.sendMessage(Text.of(TextColors.YELLOW, src.getName() + " has given you CrazyNote!"));
				src.sendMessage(Text.of(TextColors.YELLOW, targ.getName() + " has been given CrazyNote!"));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}