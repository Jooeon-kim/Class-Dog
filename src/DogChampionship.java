public class DogChampionship {
    Dog[] Fighters = new Dog[8];
    Dog[] Racers = new Dog[8];
    Dog[] Players = new Dog[6];
    DogFactory DF = new DogFactory();
    BattleManager BM = new BattleManager();
    Owner owner;
    DateEventManager DM;

    void setOwner(Owner owner) {
        this.owner = owner;
    }

    void setDM(DateEventManager dm) {
        this.DM = dm;
    }

    void FighterChampionship(Dog playerDog, boolean isIn) {
        if (!isIn) {
            Fighters[0] = DF.EnemyDogCreator(playerDog);
            for (int i = 1; i < Fighters.length; i++) {
                Fighters[i] = DF.EnemyDogCreator(playerDog);
            }
            Dog round1Winner1 = BM.DogFightAuto(Fighters[0], Fighters[1]);
            Dog round1Winner2 = BM.DogFightAuto(Fighters[2], Fighters[3]);
            Dog round1Winner3 = BM.DogFightAuto(Fighters[4], Fighters[5]);
            Dog round1Winner4 = BM.DogFightAuto(Fighters[6], Fighters[7]);
            round1Winner1.recover();
            round1Winner2.recover();
            round1Winner3.recover();
            round1Winner4.recover();
            Dog round2Winner1 = BM.DogFightAuto(round1Winner1, round1Winner2);
            Dog round2Winner2 = BM.DogFightAuto(round1Winner3, round1Winner4);
            round2Winner1.recover();
            round2Winner2.recover();
            Dog Champion = BM.DogFightAuto(round2Winner1,round2Winner2);
            System.out.println("🏆DFC 최종우승자🏆: " + Champion.name + "(" + Champion.breed + ")" + "이(가) 챔피언입니다🐕‍🦺!!!!!!!!");
        } else {
            Fighters[0] = playerDog;

            for (int i = 1; i < Fighters.length; i++) {
                Fighters[i] = DF.EnemyDogCreator(playerDog);
            }

            System.out.println("----------🐶투기장에 참가했습니다! 8강전 시작----------");
            Dog round1Winner1 = BM.DogFightPlayer(Fighters[0], Fighters[1]);
            Dog round1Winner2 = BM.DogFightAuto(Fighters[2], Fighters[3]);
            Dog round1Winner3 = BM.DogFightAuto(Fighters[4], Fighters[5]);
            Dog round1Winner4 = BM.DogFightAuto(Fighters[6], Fighters[7]);
            round1Winner1.recover();
            round1Winner2.recover();
            round1Winner3.recover();
            round1Winner4.recover();
            System.out.println("!!!!!4강진출자: | " + round1Winner1.name + " | " + round1Winner2.name + " | " + round1Winner3.name + " | " + round1Winner4.name);
            System.out.println("----------4강전 시작----------");
            Dog round2Winner1;
            if (round1Winner1 == playerDog) {
                round2Winner1 = BM.DogFightPlayer(round1Winner1, round1Winner2);
            } else {
                round2Winner1 = BM.DogFightAuto(round1Winner1, round1Winner2);
            }
            Dog round2Winner2 = BM.DogFightAuto(round1Winner3, round1Winner4);
            System.out.println("!!!!!결승 진출자: " + round2Winner1.name + " | " + round2Winner2.name);
            System.out.println("----------결승전 시작----------");
            round2Winner1.recover();
            round2Winner2.recover();
            Dog champion;
            if (round2Winner1 == playerDog) {
                champion = BM.DogFightPlayer(round2Winner1, round2Winner2);
            } else {
                champion = BM.DogFightAuto(round2Winner1, round2Winner2);
            }
            System.out.println("🏆DFC 최종우승자🏆: " + champion.name + "(" + champion.breed + ")" + "이(가) 챔피언입니다🐕‍🦺!!!!!!!!");
            playerDog.recover();
            if (champion == playerDog) {
                System.out.println("플레이어가 DFC 에서 우승하여 트로피가 추가되었습니다!");
                owner.championCount++;
                owner.championCup.add(DM.year + "/" + DM.month + "/" + DM.week + "주차 DFC 우승자🏆" + playerDog.name);
                System.out.println("상금획득");
                owner.money += 3000;
            }

        }
    }

    void RacerChampionShip(Dog playerDog, boolean isIn) {
        if (!isIn) {
            Racers[0] = DF.EnemyDogCreator(playerDog);
        } else {
            System.out.println(playerDog.name+"(이)가 DogRacer 에 참가했습니다!!");
            Racers[0] = playerDog;
        }
        for (int i = 1; i < Racers.length; i++) {
            Racers[i] = DF.EnemyDogCreator(playerDog);
        }
        Dog RacerChampion = BM.racing(Racers[0], Racers[1], Racers[2], Racers[3], Racers[4], Racers[5], Racers[6], Racers[7]);
        if (RacerChampion == playerDog) {
            System.out.println("플레이어가 DogRacer 에서 우승하여 트로피가 추가되었습니다!");
            owner.championCount++;
            owner.championCup.add(DM.year + "/" + DM.month + "/" + DM.week + "주차 DogRacer 우승자🏆" + playerDog.name);
            System.out.println("상금획득");
            owner.money += 3000;
        } else
            System.out.println("🏆DogRacer 종료🏆!" + RacerChampion.name +"("+RacerChampion.breed+")"+" 우승!🙌");
    }

    void DogShowChampionShip(Dog playerDog, boolean isIn) {
        if (!isIn) {
            Players[0] = DF.EnemyDogCreator(playerDog);
        } else {
            System.out.println(playerDog.name+"(이)가 DogShow 에 참가했습니다!!");
            Players[0] = playerDog;
        }
        for (int i = 1; i < Players.length; i++) {
            Players[i] = DF.EnemyDogCreator(playerDog);
        }
            Dog DogShowChampion = BM.dogShow(Players[0], Players[1], Players[2], Players[3], Players[4], Players[5]);
            if (DogShowChampion == playerDog) {

                System.out.println("플레이어가 DogShow 에서 우승하여 트로피가 추가되었습니다!");
                owner.championCount++;
                owner.championCup.add(DM.year + "/" + DM.month + "/" + DM.week + "주차 DogShow 우승자🏆" + playerDog.name);
                System.out.println("상금획득");
                owner.money += 3000;
            }
            System.out.println("🏆DogShow 종료🏆!" + DogShowChampion.name + "("+DogShowChampion.breed+")"+" 우승!🙌");

    }
}
