package me.runescapejon.CrazyFeet.utils;

import com.google.common.reflect.TypeToken;
import me.runescapejon.CrazyFeet.CrazyFeet;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LanguageUtils {

    public static String getPhrase(String path, Pair<String, String>... pairs) {
        ConfigurationNode node = CrazyFeet.getInstance().getLanguageConfig().getNode(path);
        String phrase = node.getString(path);
        for (Pair<String, String> pair : pairs) {
            phrase = phrase.replace(pair.getKey(), pair.getValue());
        }
        return phrase;
    }

    public static Text getText(String path, Pair<String, String>... pairs) {
        return TextSerializers.FORMATTING_CODE.deserialize(getPhrase(path, pairs));
    }

    public static List<String> getPhraseList(String path, Pair<String, String>... pairs) {
        ConfigurationNode node = CrazyFeet.getInstance().getLanguageConfig().getNode(path);
        try {
            List<String> list = node.getList(new TypeToken<String>(){});
            for (int i = 0; i < list.size(); i++) {
                String phrase = list.get(i);
                for (Pair<String, String> pair : pairs) {
                    phrase = phrase.replace(pair.getKey(), pair.getValue());
                }
                list.set(i, phrase);
            }
            return list;
        } catch (ObjectMappingException e) {
            CrazyFeet.getInstance().getLogger().warn("Configuration exception!", e);
            return new ArrayList<>();
        }
    }

    public static List<Text> getTextList(String path, Pair<String, String>... pairs) {
        return getPhraseList(path, pairs).stream().
                map(TextSerializers.FORMATTING_CODE::deserialize).
                collect(Collectors.toList());
    }
}
