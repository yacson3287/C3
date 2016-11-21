package com.cubo2d.c3;

import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;

public class vistaCalculo extends pantallaBase {

	Stage stage;
	Skin skin;
	calculos calculos;
	TextField Upt;
	TextField lwt;
	TextField dst;
	TextField Stt;
	TextField Qt;

	Label UpL;
	Label lwL;
	Label dsL;
	Label QL;

	float up_lv;
	float lw_lv;
	float dist;
	float Q;
	DecimalFormat df = new DecimalFormat("0.0000");
	public vistaCalculo(aplicacion aplicacion) {
		super(aplicacion);
		calculos = new calculos();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		stage = new Stage();
		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));

		float escala = Gdx.graphics.getWidth() / 5;

		Table table = new Table();
		table.setFillParent(true);
		// table.debug();

		UpL = new Label("*Upper Level", skin);
		UpL.setFontScale(0.7f);
		lwL = new Label("*Lower Level", skin);
		lwL.setFontScale(0.7f);
		dsL = new Label("*Distance", skin);
		dsL.setFontScale(0.7f);
		Label StL = new Label("Stope(%)", skin);
		StL.setFontScale(0.7f);
		StL.setColor(Color.CYAN);
		Upt = new TextField("", skin);
		lwt = new TextField("", skin);
		dst = new TextField("", skin);
		Stt = new TextField("", skin);

		Label MmL = new Label("*Material (manning)", skin);
		MmL.setFontScale(0.7f);
		QL = new Label("*Q (lts/sg)", skin);
		QL.setFontScale(0.7f);
		Label DL = new Label("Diameter(mts)", skin);
		DL.setFontScale(0.7f);
		DL.setColor(Color.CYAN);
		final SelectBox<String> Mmt = new SelectBox<String>(skin);
		Mmt.setItems("PVC", "CONCRETE");

		Qt = new TextField("", skin);
		final TextField Dt = new TextField("", skin);

		Label Q0L = new Label("Q0 (lts/sg)", skin);
		Q0L.setColor(Color.CYAN);
		Q0L.setFontScale(0.7f);
		Label V0L = new Label("V0 (mts/sg)", skin);
		V0L.setColor(Color.CYAN);
		V0L.setFontScale(0.7f);
		Label VL = new Label("V (mts/sg)", skin);
		VL.setColor(Color.CYAN);
		VL.setFontScale(0.7f);
		Label YL = new Label("Y (mts)", skin);
		YL.setColor(Color.CYAN);
		YL.setFontScale(0.7f);
		final TextField Q0t = new TextField("", skin);
		Q0t.setColor(Color.WHITE);
		final TextField V0t = new TextField("", skin);
		final TextField Vt = new TextField("", skin);
		final TextField Yt = new TextField("", skin);
		
		TextButton calcular = new TextButton("CALCULATE", skin);
		calcular.setColor(Color.GREEN);
		TextButton reset = new TextButton("Reset", skin);

		Label in = new Label("Input  ", skin);
		Label out = new Label("Output  ", skin);
		out.setColor(Color.CYAN);
		
		Table table2 = new Table();
		table2.setFillParent(true);
		table2.left();
		// table2.debug();

		Label tex1 = new Label("Q   = Flow of traffic.", skin);
		Label tex2 = new Label("Q0 = Flow at section full.", skin);
		Label tex3 = new Label("V    = Velocity of flow in transit.", skin);
		Label tex4 = new Label("V0 = Flow speed to the limit.", skin);
		Label tex5 = new Label("Y   = High hydraulic flow in transit.", skin);

		table2.add(tex1).fill();
		table2.row();
		table2.add(tex2).left();
		table2.row();
		table2.add(tex3).left();
		table2.row();
		table2.add(tex4).left();
		table2.row();
		table2.add(tex5).left();

		float tam = Gdx.graphics.getWidth() / 3.7f;
		Table table3 = new Table();
		table3.add(in);
		table3.add(out);
		

		// table3.debug();

		ScrollPane leyen = new ScrollPane(table2, skin);
		leyen.setColor(0f, 0f, 0, 1);

		table.add(UpL);
		table.add(lwL);
		table.add(dsL);
		table.add(StL);
		table.row();
		table.add(Upt).width(escala).padLeft(5).padRight(5).spaceBottom(5);
		table.add(lwt).width(escala).padLeft(5).padRight(5).spaceBottom(5);
		table.add(dst).width(escala).padLeft(5).padRight(5).spaceBottom(5);
		table.add(Stt).width(escala).padLeft(5).padRight(5).spaceBottom(5);
		table.row();
		table.add(MmL).colspan(2);
		table.add(QL);
		table.add(DL);
		table.row();
		table.add(Mmt).colspan(2).fill().padLeft(5).padRight(5).spaceBottom(5);
		table.add(Qt).width(escala).spaceBottom(5);
		table.add(Dt).width(escala).spaceBottom(5);

		table.row();
		table.add(Q0L);
		table.add(V0L);
		table.add(VL);
		table.add(YL);
		table.row();
		table.add(Q0t).width(escala).spaceBottom(10);
		table.add(V0t).width(escala).spaceBottom(10);
		table.add(Vt).width(escala).spaceBottom(10);
		table.add(Yt).width(escala).spaceBottom(10);
		table.row();
		table.add(calcular).colspan(2).fill().padLeft(5).padRight(5).spaceBottom(10);
		table.add();
		table.add(reset).width(escala).fill().padLeft(5).padRight(5).spaceBottom(10);
		table.row().space(5);
		table.add(table3).colspan(4).fill();
		table.row();
		table.add(leyen).colspan(4).fill();

		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);

		calcular.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {

				validar_campos();
				if (errores.size == 0) {

					try {

						calculos.setCs(up_lv);
						calculos.setCi(lw_lv);
						calculos.setDI(dist);
						calculos.setQ(Q);

						if (Mmt.getSelected().equals("PVC")) {
							calculos.setM(0.009f);
						} else {
							calculos.setM(0.013f);
						}

						calculos.calcular();

						Stt.setText(df.format(calculos.getS()*100D) + "");
						Dt.setText(df.format(calculos.getD()) + "");
						Q0t.setText(df.format(calculos.getQ0()*1000) + "");
						Vt.setText(df.format(calculos.getV()) + "");
						V0t.setText(df.format(calculos.getV0()) + "");
						Yt.setText(df.format(calculos.getY()) + "");

					} catch (Exception e) {
						System.out.println("error");
					}

				} else {

					Dialog ventanaerror = new Dialog("Error", skin);

					String texto = "";
					for (int i = 0; i < errores.size; i++) {
						texto = texto + errores.get(i) + "\n";

					}

					ventanaerror.text(texto);

					ventanaerror.button("Close").bottom();
					ventanaerror.layout();
					ventanaerror.show(stage);

				}

			}
		});

		reset.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				// TODO Auto-generated method stub

				Upt.setText("");
				lwt.setText("");
				dst.setText("");
				Dt.setText("");
				Q0t.setText("");
				Qt.setText("");
				V0t.setText("");
				Vt.setText("");
				Yt.setText("");
				Stt.setText("");
				
				UpL.setColor(Color.WHITE);
				lwL.setColor(Color.WHITE);
				dsL.setColor(Color.WHITE);
				QL.setColor(Color.WHITE);
			}
		});

	}

	Array<String> errores = new Array<String>();

	public boolean validar_campos() {

		UpL.setColor(Color.WHITE);
		lwL.setColor(Color.WHITE);
		dsL.setColor(Color.WHITE);
		QL.setColor(Color.WHITE);

		boolean ok = true;
		errores = new Array<String>();

		if (Upt.getText().equals("")) {
			ok = false;
			errores.add("*You must enter a value in Upper Level.");
			UpL.setColor(Color.RED);
		} else {
			try {
				String aux = Upt.getText().toString().replaceAll(",", "\\.");
				up_lv = Float.parseFloat(aux);
			} catch (Exception e) {
				ok = false;
				errores.add("*The data entered in Upper Level is not valid.");
				UpL.setColor(Color.RED);
			}
		}

		if (lwt.getText().equals("")) {
			ok = false;
			errores.add("*You must enter a value in Lower Level.");
			lwL.setColor(Color.RED);
		} else {
			try {
				lw_lv = Float.parseFloat(lwt.getText());
			} catch (Exception e) {
				ok = false;
				errores.add("*El dato ingresado en Lower Level no es valido ");
				lwL.setColor(Color.RED);
			}
		}

		if (dst.getText().equals("")) {
			errores.add("*The data entered in Lower Level is not valid");
			dsL.setColor(Color.RED);
		} else {
			try {
				dist = Float.parseFloat(dst.getText());
			} catch (Exception e) {
				errores.add("*The data entered in Distance is not valid");
				dsL.setColor(Color.RED);
			}
		}

		if (Qt.getText().equals("")) {
			errores.add("*You must enter a value into Q");
			QL.setColor(Color.RED);
		} else {

			try {
				Q = Float.parseFloat(Qt.getText());

			} catch (Exception e) {
				errores.add("*The data entered in Q is not valid");
				QL.setColor(Color.RED);
			}

		}

		if (ok && (up_lv <= lw_lv)) {
			errores.add("*The Upper Level value should be higher than Lower Level");
			UpL.setColor(Color.RED);
			lwL.setColor(Color.RED);
		}

		for (int i = 0; i < errores.size; i++) {
			System.out.println(errores.get(i));
		}
		System.out.println();

		return ok;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		Gdx.gl.glClearColor(0, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();

	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		
			
		stage.dispose();
	}

}
