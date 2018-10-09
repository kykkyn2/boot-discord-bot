package com.qkrwjdgus.bot.discordbot;

import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qkrwjdgus.bot.discordbot.listener.DisCordListener;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;



@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) throws LoginException {
        SpringApplication.run(DiscordBotApplication.class, args);


        JDABuilder jb = new JDABuilder(AccountType.BOT);
        jb.setAutoReconnect(true);
        jb.setStatus(OnlineStatus.ONLINE);
        jb.setToken("token");

        jb.addEventListener(new DisCordListener());
        jb.build();
    }
}
