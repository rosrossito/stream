package ua.rd.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.UUID.randomUUID;

public final class Predefined {
    public static final int DEFAULT_USER_NUM = 10;
    public static final int DEFAULT_CARD_NUM = 5;

    private static List<UUID> list = getRandomUUIDs(DEFAULT_USER_NUM);

    private Predefined() {}

    public static List<UUID> getUUIDs() {
        return list;
    }

    public static UUID getRandomUUIDFromList() {
        return list.get(getRandomNumberModListSize());
    }

    private static int getRandomNumberModListSize() {
        return ThreadLocalRandom.current().nextInt(0, DEFAULT_USER_NUM);
    }

    private static List<UUID> getRandomUUIDs(int num) {

        List <UUID> list = Stream.generate(UUID::randomUUID)
                .limit(num)
                .collect(Collectors.toList());
        return list;


//        List<UUID> list = new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//            list.add(randomUUID());
//        }
//        return list;
    }
}
