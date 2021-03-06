package com.johnathongoss.libgdxtests.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.johnathongoss.libgdxtests.Assets;
import com.johnathongoss.libgdxtests.MyGame;
import com.johnathongoss.libgdxtests.tests.AnimationTest;
import com.johnathongoss.libgdxtests.tests.BlankTestScreen;
import com.johnathongoss.libgdxtests.tests.Box2D;
import com.johnathongoss.libgdxtests.tests.Camera2D;
import com.johnathongoss.libgdxtests.tests.Collision;
import com.johnathongoss.libgdxtests.tests.HexGridTest;
import com.johnathongoss.libgdxtests.tests.LightTest;
import com.johnathongoss.libgdxtests.tests.Particles;
import com.johnathongoss.libgdxtests.tests.SpeechTest;
import com.johnathongoss.libgdxtests.tests.TooltipTest;

public class MainMenu extends BlankTestScreen {

	TextButton exampleButton, miscButton;
	private Array<TextButton> buttons;
	public MainMenu(MyGame game) {
		super(game);				
		Text.add("libGDX Tests |");
		Text.add("0.6.4.3 |");
		Text.add("johnathongoss.com |");		
	}

	@Override
	public void render(float delta) {			
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);			
		stage.act(delta);
		stage.draw();	

		stageui.act(delta);
		stageui.draw();

		renderText();		
	}	

	@Override
	public void show(){
		//Enable Ads
		game.showAds(true);
		
		Gdx.input.setInputProcessor(stageui);
		Gdx.input.setCatchBackKey(false);

		buttons = new Array<TextButton>();

		exampleButton = new TextButton("Examples", skin);
		exampleButton.setHeight(BUTTON_HEIGHT);
		exampleButton.setWidth(BUTTON_WIDTH);		
		exampleButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Examples(game));				
			}
		});	
		exampleButton.setPosition(width - BUTTON_WIDTH, height - BUTTON_HEIGHT*2);
		stageui.addActor(exampleButton);

		/**
		 * To Utils
		 */

		miscButton = new TextButton("Misc", skin);
		miscButton.setHeight(BUTTON_HEIGHT);
		miscButton.setWidth(BUTTON_WIDTH);		
		miscButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Misc(game));
			}
		});	
		miscButton.setPosition(width - BUTTON_WIDTH, height - BUTTON_HEIGHT*3);
		stageui.addActor(miscButton);

		/**
		 * To Options
		 */

		miscButton = new TextButton("Options", skin);
		miscButton.setHeight(BUTTON_HEIGHT);
		miscButton.setWidth(BUTTON_WIDTH);		
		miscButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new OptionsScreen(game));
			}
		});	
		miscButton.setPosition(width - BUTTON_WIDTH, 0);
		stageui.addActor(miscButton);		

		/*
		 * Animation
		 */

		debugButton = new TextButton("Animation", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new AnimationTest(game));
			}
		});		

		buttons.add(debugButton);	

		/*
		 * Box 2D Test
		 */

		debugButton = new TextButton("Box2D", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Box2D(game));
			}
		});		

		buttons.add(debugButton);		

		/*
		 * Camera 2D Test
		 */

		debugButton = new TextButton("Camera 2D", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Camera2D(game));
			}
		});		

		buttons.add(debugButton);		


		/*
		 * Collision Test
		 */

		debugButton = new TextButton("Collision", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Collision(game));
			}
		});		

		buttons.add(debugButton);		

		/*
		 * Hex Grid Test
		 */

		debugButton = new TextButton("Hex Grid", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new HexGridTest(game));
			}
		});		

		buttons.add(debugButton);	//TODO Re-add when complete

		/*
		 * Light Test 1
		 */

		debugButton = new TextButton("Light 1", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new LightTest(game));
			}
		});		

		buttons.add(debugButton);		


		/*
		 * Particles
		 */

		debugButton = new TextButton("Particles", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Particles(game));
			}
		});		

		buttons.add(debugButton);
		
		/*
		 * Speech Bubbles
		 */

		debugButton = new TextButton("Speech", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new SpeechTest(game));
			}
		});		

		buttons.add(debugButton);		

		/*
		 * Tooltip
		 */

		debugButton = new TextButton("Tooltip", skin);
		debugButton.setHeight(BUTTON_HEIGHT);
		debugButton.setWidth(BUTTON_WIDTH);

		debugButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new TooltipTest(game));
			}
		});		

		//buttons.add(debugButton);		

		for (TextButton button : buttons){			
			stageui.addActor(button);			
		}		
	}	

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		exampleButton.setWidth(BUTTON_WIDTH);
		exampleButton.setHeight(BUTTON_HEIGHT);
		int column = 0;
		float y_pos = height - BUTTON_HEIGHT*2;
		float x_pos = 0;

		for (int i = 0; i < buttons.size; i++){

			buttons.get(i).setPosition(x_pos, y_pos);
			y_pos -= BUTTON_HEIGHT;			

			if (i % 6 == 0 && i != 0){
				y_pos = height - BUTTON_HEIGHT*2;	
				column++;
				
				x_pos = BUTTON_WIDTH*column;
			}
		}
	}

	@Override
	protected void renderText() {

		batchui.begin();
		for (int i = 0; i < Text.size; i++)
			Assets.font24.drawMultiLine(batchui, Text.get(i), -BUTTON_WIDTH, Text.size*24 - i*24, width, HAlignment.RIGHT);
		batchui.end();
	}

	@Override
	protected void updateText() {
		// TODO Remove extend from BlankScreenTest

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}	

}
