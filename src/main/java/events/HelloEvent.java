package events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class HelloEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] msgSent = event.getMessage().getContentRaw().split(" ");
        if (msgSent[0].equalsIgnoreCase("slots")) {
            if (!Objects.requireNonNull(event.getMember()).getUser().isBot()) {
                event.getChannel().sendMessage("Wow, I love playing slots!").queue();
            }
        }
    }
//    public void onMessageReceived(MessageReceivedEvent eventA) {
//        String msg = eventA.getMessage().getContentRaw();
//        if (msg.equalsIgnoreCase("hank")) {
//            eventA.getChannel().sendMessage("wow!").queue();
//        }
//    }
}
