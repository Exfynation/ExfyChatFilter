package de.exfy.chatfilter.filter.badWord;

import de.exfy.chatfilter.filter.PatternFilter;

import java.util.Collection;

public class BadWordFilter extends PatternFilter {
    private BadWordDictionary badWordDict;

    public BadWordFilter() {
        this.badWordDict = new BadWordDictionary();
        badWordDict.addWord("schlampe", "duschlampe");
        badWordDict.addWord("nazi");
        badWordDict.addWord("hitler");
        badWordDict.addWord("anheil");
        badWordDict.addWord("sieg heil");
        badWordDict.addWord("heilhitler");
        badWordDict.addWord("fuck");
        badWordDict.addWord("shit");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("asshole", "klassik");
        badWordDict.addWord("fuckhead");
        badWordDict.addWord("fuckface");
        badWordDict.addWord("dick");
        badWordDict.addWord("shitface");
        badWordDict.addWord("asshole cleaner");
        badWordDict.addWord("fucking bitch");
        badWordDict.addWord("bitch");
        badWordDict.addWord("bastard");
        badWordDict.addWord("bitch");
        badWordDict.addWord("whore");
        badWordDict.addWord("asshole", "klassik");
        badWordDict.addWord("jackass");
        badWordDict.addWord("bastard");
        badWordDict.addWord("fuck");
        badWordDict.addWord("bulldager");
        badWordDict.addWord("shithead");
        badWordDict.addWord("cocksucker");
        badWordDict.addWord("lessy");
        badWordDict.addWord("anus", "An User");
        badWordDict.addWord("ärsche");
        badWordDict.addWord("penner");
        badWordDict.addWord("schwanz");
        badWordDict.addWord("huuren");
        badWordDict.addWord("vergewaltig");
        badWordDict.addWord("hurrren");
        badWordDict.addWord("huhren");
        badWordDict.addWord("penner");
        badWordDict.addWord("knödel");
        badWordDict.addWord("scheide");
        badWordDict.addWord("fettklops");
        badWordDict.addWord("fixer");
        badWordDict.addWord("wixer");
        badWordDict.addWord("wichser");
        badWordDict.addWord("nahkampfstachel");
        badWordDict.addWord("alkoholiker");
        badWordDict.addWord("freizeitalkoholiker");
        badWordDict.addWord("fresse");
        badWordDict.addWord("fressack");
        badWordDict.addWord("furz");
        badWordDict.addWord("suck");
        badWordDict.addWord("blow job", "zweitjob");
        badWordDict.addWord("fuck");
        badWordDict.addWord("nigger");
        badWordDict.addWord("honky");
        badWordDict.addWord("jackoff");
        badWordDict.addWord("sucker");
        badWordDict.addWord("shitass");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("cocksucker");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("twat");
        badWordDict.addWord("dick");
        badWordDict.addWord("hate", "hat ein");
        badWordDict.addWord("lesbian");
        badWordDict.addWord("cum");
        badWordDict.addWord("shithead");
        badWordDict.addWord("drugs");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("bitch");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("hooters");
        badWordDict.addWord("dick");
        badWordDict.addWord("bull shit");
        badWordDict.addWord("asshole", "klassik");
        badWordDict.addWord("butt breath");
        badWordDict.addWord("rump ranger");
        badWordDict.addWord("shit head");
        badWordDict.addWord("fuck off");
        badWordDict.addWord("dick face");
        badWordDict.addWord("suck my dick");
        badWordDict.addWord("bitch");
        badWordDict.addWord("fuck you");
        badWordDict.addWord("fuck me");
        badWordDict.addWord("fucking");
        badWordDict.addWord("farting");
        badWordDict.addWord("shiting");
        badWordDict.addWord("sperm");
        badWordDict.addWord("bastard");
        badWordDict.addWord("faggot");
        badWordDict.addWord("whore");
        badWordDict.addWord("bitch");
        badWordDict.addWord("slut");
        badWordDict.addWord("hussy");
        badWordDict.addWord("dike");
        badWordDict.addWord("lessy");
        badWordDict.addWord("piss");
        badWordDict.addWord("dickhead");
        badWordDict.addWord("puntang");
        badWordDict.addWord("bitch");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("dick");
        badWordDict.addWord("cocksucker");
        badWordDict.addWord("shithead");
        badWordDict.addWord("bullshit");
        badWordDict.addWord("asswipe");
        badWordDict.addWord("dipshit");
        badWordDict.addWord("dickbreath");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("shit face");
        badWordDict.addWord("shit for brains");
        badWordDict.addWord("one eyed bastard");
        badWordDict.addWord("fuck");
        badWordDict.addWord("shit");
        badWordDict.addWord("dick");
        badWordDict.addWord("piss");
        badWordDict.addWord("faggot");
        badWordDict.addWord("bitch");
        badWordDict.addWord("bastard");
        badWordDict.addWord("bullshit");
        badWordDict.addWord("crap");
        badWordDict.addWord("homo");
        badWordDict.addWord("shit");
        badWordDict.addWord("bitch");
        badWordDict.addWord("twat");
        badWordDict.addWord("dick");
        badWordDict.addWord("fuck");
        badWordDict.addWord("fagit");
        badWordDict.addWord("muff");
        badWordDict.addWord("bastard");
        badWordDict.addWord("cum");
        badWordDict.addWord("whore");
        badWordDict.addWord("clit");
        badWordDict.addWord("jack off");
        badWordDict.addWord("cocksucker");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("shithead");
        badWordDict.addWord("piss");
        badWordDict.addWord("shit");
        badWordDict.addWord("cocksucker");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("dick");
        badWordDict.addWord("dick head");
        badWordDict.addWord("fagget");
        badWordDict.addWord("cock");
        badWordDict.addWord("prick");
        badWordDict.addWord("butt fucker");
        badWordDict.addWord("dick cheese");
        badWordDict.addWord("bitch");
        badWordDict.addWord("son of a bitch");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("dick");
        badWordDict.addWord("fuckface");
        badWordDict.addWord("shithole");
        badWordDict.addWord("shithead");
        badWordDict.addWord("bitch");
        badWordDict.addWord("bastard");
        badWordDict.addWord("bullshit");
        badWordDict.addWord("cunt");
        badWordDict.addWord("clit");
        badWordDict.addWord("cum");
        badWordDict.addWord("cunnilingus");
        badWordDict.addWord("dick");
        badWordDict.addWord("dong");
        badWordDict.addWord("dildo");
        badWordDict.addWord("fucking");
        badWordDict.addWord("furburger");
        badWordDict.addWord("gazongers");
        badWordDict.addWord("gonads");
        badWordDict.addWord("jizz");
        badWordDict.addWord("knob");
        badWordDict.addWord("cobia");
        badWordDict.addWord("mound");
        badWordDict.addWord("quefe");
        badWordDict.addWord("shithead");
        badWordDict.addWord("pissed off");
        badWordDict.addWord("dumbass");
        badWordDict.addWord("fuckup");
        badWordDict.addWord("pissed");
        badWordDict.addWord("whore");
        badWordDict.addWord("shithead");
        badWordDict.addWord("slackass");
        badWordDict.addWord("shit");
        badWordDict.addWord("jackass");
        badWordDict.addWord("dong");
        badWordDict.addWord("shoot");
        badWordDict.addWord("buttface");
        badWordDict.addWord("fart");
        badWordDict.addWord("dag gummit");
        badWordDict.addWord("darn it");
        badWordDict.addWord("shit");
        badWordDict.addWord("dick");
        badWordDict.addWord("cock");
        badWordDict.addWord("fuck");
        badWordDict.addWord("dick");
        badWordDict.addWord("cocksucker");
        badWordDict.addWord("faggot");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("shit");
        badWordDict.addWord("pussy lip");
        badWordDict.addWord("twat");
        badWordDict.addWord("dick wrinkle");
        badWordDict.addWord("bull shit");
        badWordDict.addWord("whore");
        badWordDict.addWord("jerk");
        badWordDict.addWord("bastard");
        badWordDict.addWord("whore");
        badWordDict.addWord("mierda");
        badWordDict.addWord("piss");
        badWordDict.addWord("bitch");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("shit");
        badWordDict.addWord("dick");
        badWordDict.addWord("fuck");
        badWordDict.addWord("piss");
        badWordDict.addWord("bitch");
        badWordDict.addWord("bastard");
        badWordDict.addWord("bullshit");
        badWordDict.addWord("masterbate");
        badWordDict.addWord("hussy");
        badWordDict.addWord("slut");
        badWordDict.addWord("jackass");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("clit");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("piss");
        badWordDict.addWord("bitch");
        badWordDict.addWord("shithead");
        badWordDict.addWord("whore");
        badWordDict.addWord("fucker");
        badWordDict.addWord("fareskin");
        badWordDict.addWord("schmeka");
        badWordDict.addWord("fart");
        badWordDict.addWord("shitface");
        badWordDict.addWord("whore");
        badWordDict.addWord("heil");
        badWordDict.addWord("porn");
        badWordDict.addWord("gomme");
        badWordDict.addWord("minehook");
        badWordDict.addWord("anhai");
        badWordDict.addWord("depp");
        badWordDict.addWord("dummkopf");
        badWordDict.addWord("arsch");
        badWordDict.addWord("hure");
        badWordDict.addWord("fick");
        badWordDict.addWord("fotz");
        badWordDict.addWord("spast");
        badWordDict.addWord("vollpfosten");
        badWordDict.addWord("adolf");
        badWordDict.addWord("looser");
        badWordDict.addWord("spast");
        badWordDict.addWord("slut");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("bitch");
        badWordDict.addWord("bastard");
        badWordDict.addWord("allah");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("pussydick");
        badWordDict.addWord("fuck");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuckbutt");
        badWordDict.addWord("dickhead");
        badWordDict.addWord("pussy");
        badWordDict.addWord("shithead");
        badWordDict.addWord("pussylips");
        badWordDict.addWord("piss ant");
        badWordDict.addWord("slutty bitch");
        badWordDict.addWord("cheesy ass");
        badWordDict.addWord("whore dog");
        badWordDict.addWord("dick");
        badWordDict.addWord("dickhead");
        badWordDict.addWord("dickless");
        badWordDict.addWord("faggot");
        badWordDict.addWord("asshole", "klassik");
        badWordDict.addWord("shit");
        badWordDict.addWord("fuck");
        badWordDict.addWord("fuck you");
        badWordDict.addWord("fuck off");
        badWordDict.addWord("piss off");
        badWordDict.addWord("motherfucker");
        badWordDict.addWord("bitch");
        badWordDict.addWord("crap");
        badWordDict.addWord("fart");
        badWordDict.addWord("piss");
        badWordDict.addWord("jesus christ");
        badWordDict.addWord("christ");
        badWordDict.addWord("jeez");
        badWordDict.addWord("dick");
        badWordDict.addWord("boner");
        badWordDict.addWord("prick");
        badWordDict.addWord("boob");
        badWordDict.addWord("spic");
        badWordDict.addWord("nigger");
        badWordDict.addWord("mick");
        badWordDict.addWord("polack");
        badWordDict.addWord("bitch");
        badWordDict.addWord("bastard");
        badWordDict.addWord("motherfucker");
    }

    @Override
    protected boolean couldBeBadWordPrefix(String text) {
        return badWordDict.isBadWordPrefix(text);
    }

    @Override
    protected boolean isBadWord(String text) {
        return badWordDict.isBadWord(text);
    }

    @Override
    protected Collection<String> getExceptions(String text) {
        return badWordDict.getExceptions(text);
    }
}
