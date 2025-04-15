public interface DogObserver {
    void onLoyaltyChanged(Dog dog,int newLoyalty);
    void onHealthChanged(Dog dog,int newHealth);
}
interface Attackers{
    int attack();
}
interface showInfo{
    void info();
}