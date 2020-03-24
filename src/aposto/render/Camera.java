package aposto.render;

import org.lwjgl.util.glu.GLU;
import aposto.math.Vector3f;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Camera {

	private float fov;
	private float zNear;
	private float zFar;

	private Vector3f position;
	private Vector3f rotation;

	public Camera(Vector3f position) {
		this.position = position;
		rotation = new Vector3f();
	}

	public Camera setPerspectiveProjection(float fov, float zNear, float zFar) {
		this.fov = fov;
		this.zNear = zNear;
		this.zFar = zFar;

		return this;
	}

	public Vector3f getForward() {
		Vector3f r = new Vector3f();
		Vector3f rot = new Vector3f(rotation);

		float cosY = (float) Math.cos(Math.toRadians(rot.getY() + 90));
		float sinY = (float) Math.sin(Math.toRadians(rot.getY() + 90));
		float cosP = (float) Math.cos(Math.toRadians(rot.getX()));
		float sinP = (float) Math.sin(Math.toRadians(rot.getX()));

		r.setX(cosY * cosP);
		r.setY(sinP);
		r.setZ(sinY * cosP);

		return r;
	}

	public Vector3f getRight() {
		Vector3f r = new Vector3f();
		Vector3f rot = new Vector3f(rotation);

		float cosY = (float) Math.cos(Math.toRadians(rot.getY()));
		float sinY = (float) Math.sin(Math.toRadians(rot.getY()));

		r.setX(cosY);
		r.setZ(sinY);

		return r;
	}

	public void getPerspectiveProjection() {
		glEnable(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(fov, (float) DisplayManager.getWidth() / (float) DisplayManager.getHeight(), zNear, zFar);
		glEnable(GL_MODELVIEW);
	}

	public void update() {
		glPushAttrib(GL_TRANSFORM_BIT);
		glRotatef(rotation.getX(), 1, 0, 0);
		glRotatef(rotation.getY(), 0, 1, 0);
		glRotatef(rotation.getZ(), 0, 0, 1);
		glTranslatef(-position.getX(), -position.getY(), -position.getZ());
		glPopMatrix();
	}

	float speed = 0.05f;

	public void input() {
		if (rotation.getX() > 90)
			rotation.setX(90);
		if (rotation.getX() < -90)
			rotation.setX(-90);

		rotation.addX(-Mouse.getDY());
		rotation.addY(Mouse.getDX());

		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			position.add(getForward().mul(new Vector3f(-speed, -speed, -speed)));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.add(getForward().mul(new Vector3f(speed, speed, speed)));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			position.add(getRight().mul(new Vector3f(-speed, -speed, -speed)));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.add(getRight().mul(new Vector3f(speed, speed, speed)));
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.addY(0.01f);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			position.addY(-0.01f);
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}
}
