package events;

import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HelloEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] msgSent = event.getMessage().getContentRaw().split(" ");
        String name = Objects.requireNonNull(event.getMember()).getUser().getName();
        if (msgSent[0].equalsIgnoreCase("hi")) {
            event.getChannel().sendMessage("Hello " + event.getAuthor().getAsMention() + "!").queue();
        }
        if (msgSent[0].equalsIgnoreCase("slots")) {
            if (!Objects.requireNonNull(event.getMember()).getUser().isBot()) {
                event.getChannel().sendMessage("Wow, I love playing slots!").queue();
                event.getChannel().sendMessage(":joy:").queue();
                String x;
                if (event.getChannel().hasLatestMessage()) {
                    x = event.getChannel().getLatestMessageId();
                    event.getChannel().editMessageById(x, "What").queue();
                }
//                event.getChannel().retrieveMessageById(x).
//                event.getChannel().edit(x, ":joy_cat:").queue();//change this or remove!

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
