package events;

import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.WidgetUtil.Widget.Member;
import net.dv8tion.jda.api.requests.RestAction;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Slots extends ListenerAdapter {

    public int randEditSlotEmote(GuildMessageReceivedEvent event, long botMsgId) {
        long startTime = System.currentTimeMillis();
        Random rand = new Random();
        int n = rand.nextInt(10);
        int previousN = n;
        System.out.print("n = " + n + ", ");

        double elapsedTime = 0L;
        int randINT = rand.nextInt(3);
        System.out.println("randINT = " + randINT + ", ");
        float randFLOAT = rand.nextFloat();
        System.out.print("randFLOAT = " + randFLOAT + "\n");
        //Should have at least a 3 second duration before the slot machine stops spinning

        long delayTime = 850L;
        long delayMultiplier = 1L; //this will keep increasing to give enough time for visible changes to occur.
        int spamChecker = 0;

        while(elapsedTime <= (1000) * (3 + randINT + randFLOAT)) {
            if ((elapsedTime/1000) % 1 == 0) {
                if (spamChecker == 0) {
                    n = rand.nextInt(10);
                    while (n == previousN) {
                        n = rand.nextInt(10); //makes sure that the same emoji isnt printed twice in a row.
                    }

                    switch (n) {
                        case 0:
                            event.getChannel().editMessageById(botMsgId, ":bell:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println("normal function's :bell:");
                            break;
                        case 1:
                            event.getChannel().editMessageById(botMsgId, ":tangerine:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":tangerine:");
                            break;
                        case 2:
                            event.getChannel().editMessageById(botMsgId, ":watermelon:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":watermelon:");
                            break;
                        case 3:
                            event.getChannel().editMessageById(botMsgId, ":grapes:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":grapes:");
                            break;
                        case 4:
                            event.getChannel().editMessageById(botMsgId, ":cherries:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":cherries:");
                            break;
                        case 5:
                            event.getChannel().editMessageById(botMsgId, ":lemon:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":lemon:");
                            break;
                        case 6:
                            event.getChannel().editMessageById(botMsgId, ":four_leaf_clover:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":four_leaf_clover:");
                            break;
                        case 7:
                            event.getChannel().editMessageById(botMsgId, ":seven:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":seven:");
                            break;
                        case 8:
                            event.getChannel().editMessageById(botMsgId, ":dollar:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":dollar:");
                            break;
                        case 9:
                            event.getChannel().editMessageById(botMsgId, ":gem:").queueAfter(delayTime*delayMultiplier, TimeUnit.MILLISECONDS);
                            System.out.println(":gem:");
                            break;
                    }
                    previousN = n;
                    spamChecker = 1;
//                    delayMultiplier++; //this may serve a purpose if things get overloaded perhaps.
                }
            }
            else {
                spamChecker = 0;
            }
            elapsedTime = (new Date()).getTime() - startTime;
        //add stuff here for sure, method not done
        }
        return previousN;
    }

    public int randEditSlotOutcome(GuildMessageReceivedEvent event, long botMsgId, int columnA, int columnB, int numberOfProbabilities) {
        Random rand = new Random();
        if (numberOfProbabilities <= 0) {
            return -1;
        }
        int probabilityOutcome = rand.nextInt(numberOfProbabilities-1);
        System.out.println("NumberOfProbabilities = " + numberOfProbabilities + ", probability = " + (((double)1/numberOfProbabilities)*(100)) + "%, " + "probabilityOutcome = " + probabilityOutcome);
        System.out.println("columnA = " + columnA + ", columnB = " + columnB);
        if (probabilityOutcome == 0 && columnA != columnB) {
            switch (columnA) {
                case 0:
                    event.getChannel().editMessageById(botMsgId, ":bell:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :bell:\n");
                    break;
                case 1:
                    event.getChannel().editMessageById(botMsgId, ":tangerine:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :tangerine:\n");
                    break;
                case 2:
                    event.getChannel().editMessageById(botMsgId, ":watermelon:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :watermelon:\n");
                    break;
                case 3:
                    event.getChannel().editMessageById(botMsgId, ":grapes:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :grapes:\n");
                    break;
                case 4:
                    event.getChannel().editMessageById(botMsgId, ":cherries:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :cherries:\n");
                    break;
                case 5:
                    event.getChannel().editMessageById(botMsgId, ":lemon:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :lemon:\n");
                    break;
                case 6:
                    event.getChannel().editMessageById(botMsgId, ":four_leaf_clover:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :four_leaf_clover:\n");
                    break;
                case 7:
                    event.getChannel().editMessageById(botMsgId, ":seven:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :seven:\n");
                    break;
                case 8:
                    event.getChannel().editMessageById(botMsgId, ":dollar:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :dollar:\n");
                    break;
                case 9:
                    event.getChannel().editMessageById(botMsgId, ":gem:").queueAfter(850, TimeUnit.MILLISECONDS);
                    System.out.println("NEWFUNC = :gem:\n");
                    break;
            }
            return columnA;
        }
        return columnB;
    }

    int rowOfSlotMachine = 0; //indicates which row of the slot machine is currently being displayed.
    int rowOutcomes[] = new int[3];

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

//        System.out.println(event.getMessageId());

        String[] msgSent = event.getMessage().getContentRaw().split(" ");
        String name = Objects.requireNonNull(event.getMember()).getUser().getName();
        if (msgSent[0].equalsIgnoreCase("hi")) {
            event.getChannel().sendMessage("Hello " + event.getAuthor().getAsMention() + "!").queue();
        }
        if (msgSent[0].equalsIgnoreCase("slots")) {
            if (!Objects.requireNonNull(event.getMember()).getUser().isBot()) {
//                  String x;
                event.getChannel().sendMessage("First column!").queue();
//                  x = event.getChannel().getLatestMessageId();
//                  System.out.println("Wow i love playing slots = " + x);
                event.getChannel().sendMessage(":slot_machine:").queueAfter(750, TimeUnit.MILLISECONDS);
                rowOfSlotMachine = 1;
//                  x = event.getChannel().getLatestMessageId();
//                  System.out.println(":joy: = " + x);
//                  if (event.getChannel().hasLatestMessage()) {
//                      x = event.getChannel().getLatestMessageId();
//                      System.out.println("latest message? = " + x);
//                      event.getChannel().editMessageById(x, "What").queue();
//                  }
            }
        }

        //edits the bots message to change, akin to a digital text chat based slot machine
        if (event.getMember().getUser().isBot() && event.getMessage().getContentRaw().equalsIgnoreCase(":slot_machine:") && rowOfSlotMachine <= 3 && rowOfSlotMachine > 0) {
//            System.out.println("reached, rowOfSlotMachine = " + rowOfSlotMachine);
            long botMsgId = event.getChannel().getLatestMessageIdLong();
            rowOutcomes[rowOfSlotMachine-1] = randEditSlotEmote(event, botMsgId);
            if (rowOfSlotMachine == 1) {
                System.out.println("column 1 outcome = " + rowOutcomes[0] + "\n");
                event.getChannel().sendMessage("Second column!").queueAfter(1000, TimeUnit.MILLISECONDS);
//                System.out.println("Second column");
                event.getChannel().sendMessage(":slot_machine:").queueAfter(1000, TimeUnit.MILLISECONDS);
                rowOfSlotMachine++;
            }
            else if (rowOfSlotMachine == 2) {
                System.out.println("column 2 outcome = " + rowOutcomes[1] + "\n");
                //add a function here that randomly decides to make the first and second column have the same emoji, EDIT: I HAVE ADDED IT JUST BELOW!!!
                rowOutcomes[1] = randEditSlotOutcome(event, botMsgId, rowOutcomes[0], rowOutcomes[1], 2);
                event.getChannel().sendMessage("Third column!").queueAfter(1000, TimeUnit.MILLISECONDS);
//                System.out.println("Third column");
                event.getChannel().sendMessage(":slot_machine:").queueAfter(1000, TimeUnit.MILLISECONDS);
                rowOfSlotMachine++;
            }
            else if (rowOfSlotMachine >= 3) {
                System.out.println("column 3 outcome = " + rowOutcomes[2] + "\n");
                //add a function here that randomly decides to make the first and second column have the same emoji, EDIT: I HAVE ADDED IT JUST BELOW!!!
                rowOutcomes[2] = randEditSlotOutcome(event, botMsgId, rowOutcomes[0], rowOutcomes[2], 4);
                if (rowOutcomes[0] == rowOutcomes[1] && rowOutcomes[0] == rowOutcomes[2]) {
                    event.getChannel().sendMessage("Wow! You got 3 in a row!").queueAfter(1200, TimeUnit.MILLISECONDS);
                }
                else {
                    event.getChannel().sendMessage("... Not even close.").queueAfter(1200, TimeUnit.MILLISECONDS);
                }
//                System.out.println("...");
                rowOfSlotMachine = 0;
            }
//            event.getChannel().editMessageById(botMsgId, ":grapes:").queueAfter(750, TimeUnit.MILLISECONDS);
//            event.getChannel().editMessageById(botMsgId, ":seven:").queueAfter(1500, TimeUnit.MILLISECONDS);// Make this so that it edits messages a random amount of times (think for loops or maybe even while loops)
            //, so that it feels more like a slot machine, also make it so that random emojis (except the one that its currently on is avoided) are selected every iteration of that loop.
        }
//        if (event.getMember().getUser().isBot() && event.getMessage().getContentRaw().equalsIgnoreCase(":slot_machine:")) {
//            long botMsgId = event.getChannel().getLatestMessageIdLong();
//            randEditSlotEmote(event, botMsgId);
//            event.getChannel().sendMessage("Third column!").queueAfter(850, TimeUnit.MILLISECONDS);
//
//        }
//        if (event.getMember().getUser().isBot() && event.getMessage().getContentRaw().equalsIgnoreCase("Third column!")) {
//            long botMsgId = event.getChannel().getLatestMessageIdLong();
//            randEditSlotEmote(event, botMsgId);
//            event.getChannel().sendMessage("...").queueAfter(850, TimeUnit.MILLISECONDS);
//        }
    }
//    public void onMessageReceived(MessageReceivedEvent eventA) {
//        String msg = eventA.getMessage().getContentRaw();
//        if (msg.equalsIgnoreCase("hank")) {
//            eventA.getChannel().sendMessage("wow!").queue();
//        }
//    }
}
