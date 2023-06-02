package src.main.java.seminar2.task2;

import src.main.java.seminar2.task1.Actor;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Actor> queue;
    // TODO сделать список в конструкторе

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + "Человек пришёл в махазин");
        takeInQueue(actor);

    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + "Встал в очередь");
        queue.add(actor);
        this.queue.add(actor);


    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + "Сделал заказ");
            }
        }

    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + "Получил заказ");
            }
        }


    }


    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor);
                System.out.println(actor.getName() + "Вышел из очереди");
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        for (Actor actor : actorList) {
            System.out.println(actor.getName() + "Вышел из магазина");
            queue.remove(actor);
        }
    }


    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    }
