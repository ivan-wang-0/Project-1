public class Main {
    public static void main(String[] args) {
        MontyHallSimulation.play(100000);
    }
}
/* pg 34, 2.20

a) P(g) = 1/3

b)
    1) S = {G, D1, D2}
       P(G) = 1/3
    2) She would pick the dud.
    3) She would pick the prize.
    4) Since picking a dud and switching will guarantee the prize and the probability of choosing a dud is 2/3,
       the probability of winning the prize after switching is also 2/3.
    5) Always switching your option will have a greater chance of picking the prize.

 */