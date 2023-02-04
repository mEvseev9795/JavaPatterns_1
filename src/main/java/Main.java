public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        System.out.println("Мы знаем возраст " + mom + "? " + son.hasAge());
        System.out.println("Мы знаем возраст " + son + "? " + mom.hasAge());
        System.out.println("Возраст " + mom + " = " + mom.getAge().getAsInt());

        if (son.hasAge()) {
            System.out.println("Возраст " + son + " = " + son.getAge().getAsInt());
            son.happyBirthday();
            System.out.println("С Днем Рождения " + son + ", тебе исполнилось " + son.getAge().getAsInt());
        }

        System.out.println("Мы знаем адрес " + mom + "? " + son.hasAddress());
        System.out.println("Мы знаем адрес " + son + "? " + mom.hasAddress());
        System.out.println("Адрес " + mom + ": " + son.getAddress());
        System.out.println("Адрес " + son + ": " + mom.getAddress());

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}