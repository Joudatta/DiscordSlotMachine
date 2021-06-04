import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    public static String prefix = "!";
    public static String token = "ODQ3OTY5MjcwNjc5NDcwMTIw.YLFy7A.5tFXLj_RBGI8rZ14Yevd9oX2tw4";

//    private Bot() throws LoginException {
//        JDABuilder jda = JDABuilder.createDefault(token);
//        jda.addEventListeners(new Bot()).setActivity(Activity.watching("your every move."));
//        jda.build();
//        CommandClientBuilder ez = new CommandClientBuilder();
//        ez.setOwnerId("847969270679470120");
//        ez.setPrefix(prefix);
//        ez.setHelpWord("help");
//        ez.addCommand(new ServerInfo());

//        CommandClient client = ez.build();
//        jda.addEventListeners(client);
//    }

    public static void main(String[] args) throws Exception {
//        new Bot();
//        System.out.println("Bot enabled!!!");
        JDA jda = JDABuilder.createDefault(token).build();
        jda.addEventListener(new HelloEvent());

    }


}
