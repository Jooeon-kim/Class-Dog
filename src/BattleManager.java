import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleManager {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    Dog DogFightAuto(Dog dog1, Dog dog2) {
        Dog firstAttacker = dog1.speed >= dog2.speed ? dog1 : dog2;
        Dog lastAttacker = dog1.speed >= dog2.speed ? dog2 : dog1;
        Dog winner = null;
        while (true) {
            if (lastAttacker.health > 0) {
                int damage = firstAttacker.attack();
                lastAttacker.hit(damage);

                if (lastAttacker.health <= 0) {
                    winner = firstAttacker;
                    break;
                }
            }
            if (firstAttacker.health > 0) {
                int damage = lastAttacker.attack();
                firstAttacker.hit(damage);

                if (firstAttacker.health <= 0) {
                    winner = lastAttacker;
                    break;
                }
            }

        }
        return winner;
    }

    Dog DogFightPlayer(Dog playerDog, Dog enemyDog) {
        System.out.println("전투시작! " + playerDog.name + " vs " + enemyDog.name);
        Dog firstAttacker = playerDog.speed >= enemyDog.speed ? playerDog : enemyDog;
        Dog lastAttacker = playerDog.speed < enemyDog.speed ? playerDog : enemyDog;
        System.out.println("선공: " + firstAttacker.name);
        Dog winner = null;
        while (true) {
            if (lastAttacker.health > 0) {
                int damage = firstAttacker.attack();
                System.out.println(firstAttacker.name + "(이)가" + damage + "만큼의 데미지를 주었습니다👊");

                lastAttacker.hit(damage);

                if (lastAttacker.health <= 0) {
                    winner = firstAttacker;
                    break;
                }
            }
            if (firstAttacker.health > 0) {
                int damage = lastAttacker.attack();
                System.out.println(lastAttacker.name + "(이)가" + damage + "만큼의 데미지를 주었습니다👊");
                firstAttacker.hit(damage);
                if (firstAttacker.health <= 0) {
                    winner = lastAttacker;
                    break;
                }
            }

        }
        if (winner == playerDog) {
            System.out.println("🎉 승리! 라운드 진출 성공!");
        } else {
            System.out.println("😢 패배! 라운드 진출에 실패했습니다.");
        }
        System.out.println("🐶승자: " + winner.name + " (" + winner.breed + ")");
        return winner;

    }

    Dog racing(Dog dog1, Dog dog2, Dog dog3, Dog dog4, Dog dog5, Dog dog6, Dog dog7, Dog dog8) {
        Dog[] racers = {dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8};
        Arrays.sort(racers, (a, b) -> {
            int scoreA = a.speed + a.strength / 2;
            int scoreB = b.speed + b.strength / 2;
            return Integer.compare(scoreB, scoreA);
        });

        System.out.println("🏁 레이싱 결과!");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "등: " + racers[i].name + " (속도:" + racers[i].speed + ", 힘:" + racers[i].strength + ")");
        }
        return racers[0];
    }

    Dog dogShow(Dog dog1, Dog dog2, Dog dog3, Dog dog4, Dog dog5, Dog dog6) {
        Dog[] players = {dog1, dog2, dog3, dog4, dog5, dog6};
        Dog champion = players[0];
        int maxScore = champion.attractive + champion.intelligence;

        for (int i = 1; i < players.length; i++) {
            int score = players[i].attractive + players[i].intelligence;
            if (score > maxScore) {
                champion = players[i];
                maxScore = score;
            }
        }

        System.out.println("🎉도그쇼 우승자: " + champion.name);

        return champion;
    }

    Cat CatVsDog(Dog playerDog, Cat enemy) {
        System.out.println("전투시작! " + playerDog.name + " vs " + enemy.name);
        System.out.println("선공: " + enemy.name);
        while (true) {
            if (playerDog.health > 0) {
                int damage = enemy.attack();
                System.out.println(enemy.name + "(이)가" + damage + "만큼의 데미지를 주었습니다👊");
                playerDog.hit(damage);

                if (playerDog.health <= 0) {
                    System.out.println(playerDog.name+"가 "+enemy.name+" 에게 패배했습니다");
                    return null;
                }
            }
            if (enemy.health > 0) {
                int damage = playerDog.attack();
                enemy.hit(damage);
                System.out.println(playerDog.name + "(이)가" + damage + "만큼의 데미지를 주었습니다👊");

                if (enemy.health <= 0) {
                    System.out.println(enemy.name+" 사망!");
                    System.out.println("고양이 사냥목록에 추가되었습니다!");
                    return enemy;
                }
            }

        }
    }
}