package observer;

public class Main {

    public static void main(String[] args) {

		AnimeNotification an = new AnimeNotification("Shingeki no Kyojin");
		MangaNotification mn = new MangaNotification("Goblin Slayer");

		AnimeObserver ao1 = new AnimeObserver(an);
		MangaObserver mo1 = new MangaObserver(mn);
		AnimeObserver ao2 = new AnimeObserver(an);
		MangaObserver mo2 = new MangaObserver(mn);
		AnimeObserver ao3 = new AnimeObserver(an);
		MangaObserver mo3 = new MangaObserver(mn);

		an.setNotif("Shingeki no Kyojin");
		mn.setNotif("Goblin Slayer");

		an.removeObserver(ao2);
		an.setNotif("Shingeki no Kyojin");

    }
}
