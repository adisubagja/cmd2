import java.util.Random;

public class EnemyScene extends Scene {

	private Enemy enemy;
	private int mapLevel;


	private boolean lockLog;
	private boolean encounterLog;


	public EnemyScene(Game game) {
		super(game);
	}

	private void cloneEnemy(Enemy original) {
		Enemy clone = new Enemy(original.getImage(), original.getName(), original.getHp() + mapLevel, original.getAttack() + mapLevel, original.getDeffense() + mapLevel, original.getSpeed() + mapLevel, original.getLuck() + original.getLuckIncrement(mapLevel));
		enemy = clone;
	}

	public void configureEnemies(String enemies, int mapLevel) {
		this.mapLevel = mapLevel;
		Enemy original = null;
		String[] splitted = enemies.split(" ");
		if (splitted.length > 1) {

			int[] ranges = new int[splitted.length];
			String[] names = new String[splitted.length];

			for (int i = 0; i < splitted.length; i++) {
				String[] tempDuo = splitted[i].split("_");
				names[i] = tempDuo[0];
				ranges[i] = Integer.parseInt(tempDuo[1]);
			}

			int random = new Random().nextInt(100); //0~99

			for (int i = 0; i < ranges.length; i++) {
				if (random < ranges[i]) {
					original = game.getEnemies().get(names[i]);
					break;
				}
			}
		} else {
			String[] temp = enemies.split("_");
			original = game.getEnemies().get(temp[0]);
		}
		cloneEnemy(original);

		encounterLog = true;
		lockLog = false;
	}

	@Override
	public void update() {
		super.update();

		if (player.isAlive() && enemy.isAlive()) {
			if (res.equalsIgnoreCase("run")) {
				game.changeScene();
			} else if (res.equalsIgnoreCase("attack")) {
				boolean playerFirst = false;
				if (enemy.getSpeed() == game.getPlayer().getSpeed()) {
					int random = new Random().nextInt(2);
					if (random % 2 == 0) {
						playerFirst = true;
					}
				} else if (enemy.getSpeed() < game.getPlayer().getSpeed()) {
					playerFirst = true;
				}
				if (playerFirst) {
					player.attack(enemy);
					if (enemy.isAlive()) {
						enemy.attack(player);	
					} else {
						player.levelUp(game.getExp(mapLevel));
					}
				} else {
					enemy.attack(player);
					if (player.isAlive()) {
						player.attack(enemy);	
					}
				}
				lockLog = false;
			}
		} else {
			res = ""; //soh por seguranca, ver se pode apagar
			//change scene soh no caso do inimigo morto, player = game over
			game.changeScene();
		}			
		clearScreen();
	}

	@Override
	public void render() {
		enemy.render();

		if (encounterLog) {
			System.out.println("VOCE ENCONTROU UM PENIS LONGO");
			encounterLog = false;
		} else if (!lockLog) {
			player.displayBattleLog();
			enemy.displayBattleLog();
		}

		System.out.println("Player HP: " + player.getHp());
		System.out.println(enemy.getName() + " HP: " + enemy.getHp());

		lockLog = true;
	}

	@Override
	public void reset() {
		//		
	}

}