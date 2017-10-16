package me.runescapejon.CrazyFeet.Commands.head;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;
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
		final ArrayList<UUID> cPearlHead = CrazyFeet.getInstance().getCrazyPearlHead();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazypearlhead")) {
				if (cPearlHead.contains(player.getUniqueId())) {
					cPearlHead.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyPearlHeadDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cPearlHead.add(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyPearlHeadEnabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazypearlheadother")) {
			Player targ = target.get();

			if (cPearlHead.contains(targ.getUniqueId())) {
				cPearlHead.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyPearlHeadDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyPearlHeadDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cPearlHead.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyPearlHeadEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyPearlHeadEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
