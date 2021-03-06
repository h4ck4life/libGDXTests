package com.johnathongoss.libgdxtests.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.johnathongoss.libgdxtests.Assets;
import com.johnathongoss.libgdxtests.ImageCache;
import com.johnathongoss.libgdxtests.MyGame;
import com.johnathongoss.libgdxtests.MyInputProcessor;
import com.johnathongoss.libgdxtests.screens.MainMenu;

public class Camera2D extends BlankTestScreen{	
	protected TextureRegion background = ImageCache.getTexture("background");
	protected Sprite sprite;
	protected float camX;
	protected float camY;
	protected float camZ;
	protected float camZoom;
	
	MyInputProcessor input = new MyInputProcessor(){

		@Override
		public boolean keyUp(int keycode) {
			if(keycode == Keys.BACK || 
					keycode == Keys.BACKSPACE ||
					keycode == Keys.ESCAPE){
				game.setScreen(new MainMenu(game));
			}
			return false;
		}
	};

	public Camera2D(MyGame game) {
		super(game);
		sprite = new Sprite(background);
		sprite.setPosition(0, 0);
		sprite.setOrigin(0, 0);
		sprite.setScale((float)Gdx.app.getGraphics().getWidth() / (float)background.getRegionWidth(), (float)Gdx.app.getGraphics().getHeight() / (float)background.getRegionHeight());
		//sprite.setSize(1f, 1f);
		//sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);			
		//batch.setProjectionMatrix(cam.combined);
		batch.begin();		
		sprite.draw(batch);
		//		batch.draw(background, 0, 0, 
		//				background.getRegionWidth()/2, background.getRegionHeight()/2, 				
		//				background.getRegionWidth(), background.getRegionHeight(), 
		//				(float)Gdx.app.getGraphics().getWidth() / (float)background.getRegionWidth(), (float)Gdx.app.getGraphics().getHeight() / (float)background.getRegionHeight(),				0);
		//batch.draw(background, 0, 0, background.getRegionWidth(), background.getRegionHeight());
		batch.end();

		stage.act(delta);		
		stage.draw();

		updateText();
		renderText();

		stageui.act();
		stageui.draw();

		controller.update();
		//controller.updateBounds();
		//cam.translate(1, 1);
		cam.update();
		batch.setProjectionMatrix(cam.combined);

	}	

	@Override
	protected void updateText(){

		Text.clear();
		Text.add("x: " + (int)cam.position.x + " y: " + (int)cam.position.y + " |");
		Text.add("Zoom: " + cam.zoom + " |");
		//Text.add("Zoom: " + cam.direction + " |");
		//Text.add(controller.boundX + " " + controller.boundX2);
	}

	@Override
	protected void renderText(){


		batchui.begin();
		Assets.font24.setColor(1, 1, 1, 0.8f);
		for (int i = 0; i < Text.size; i++){			
			Assets.font24.drawMultiLine(batchui, Text.get(i), 0, height - BUTTON_HEIGHT*2 - 24 - i*24, width, HAlignment.RIGHT);
		}
		renderTestName(batchui);
		batchui.end();
	}

	@Override
	public void show() {
		//Disable Ads for tests
		game.showAds(true);

		testName = "Camera 2D Test |";
		addCameraControl(width, 0, height, 0);
		addBackButton();
		controller = new CameraController();
		controller.setBounds(width, 0, height, 0);
		gestureDetector = new GestureDetector(20, 0.5f, 2, 0.15f, controller);
		InputMultiplexer im = new InputMultiplexer(stageui, stage, gestureDetector, this, input);
		Gdx.input.setInputProcessor(im);		
		Gdx.input.setCatchBackKey(true);

		cam.zoom = 1.4f;
		camX = cam.position.x;
		camY = cam.position.y;
		camZ = cam.position.z;
		camZoom = cam.zoom;

		/*
		 * Reset
		 */		

		debugButton = new TextButton("Reset Camera", skin);
		debugButton.addListener(new ClickListener() {			

			@Override
			public void clicked(InputEvent event, float x, float y) {
				cam.position.set(camX, camY, camZ);
				cam.zoom = camZoom;
				controller.velX = 0;
				controller.velY = 0;
			}

		});		
		buttons.add(debugButton);	

		for (TextButton button : buttons)
			stageui.addActor(button);			

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.BACK){
			game.setScreen(new MainMenu(game));
		}
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
