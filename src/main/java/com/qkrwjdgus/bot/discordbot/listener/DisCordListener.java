package com.qkrwjdgus.bot.discordbot.listener;

import java.util.List;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class DisCordListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User user = event.getAuthor();
        TextChannel tc = event.getTextChannel();
        Message msg = event.getMessage();

        if (user.isBot()) {
            System.out.println("봇입니다.");
            return;
        }

        if (msg.getContentRaw().charAt(0) == '!') {
            String[] args = msg.getContentRaw().substring(1).split(" ");
            if (args.length <= 0) {
                return;
            }
            if (args[0].equalsIgnoreCase("clear")) {
                MessageHistory mh = new MessageHistory(tc);
                // 아래는 최소 2개 이상부터 100개 까지 제한
                List<Message> list = mh.retrievePast(1).complete();
                tc.deleteMessages(list).complete();
                tc.sendMessage("제거").queue();
            }
        }

    }
}
