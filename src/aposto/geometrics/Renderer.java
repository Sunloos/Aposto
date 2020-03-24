package aposto.geometrics;

import org.lwjgl.opengl.GL11;
import aposto.math.Vector3f;

public class Renderer {
	
	public static void addDoubleSurface(float x, float y, float z, Vector3f color) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x + 1, y, z);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x, y, z + 1);
		GL11.glVertex3f(x + 1, y, z + 1);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x + 1, y, z);
		GL11.glVertex3f(x + 1, y, z + 1);
		GL11.glVertex3f(x, y, z + 1);
		GL11.glEnd();
	}

	public static void addSurface(float x, float y, float z, Vector3f color) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x + 1, y, z);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x, y, z + 1);
		GL11.glVertex3f(x + 1, y, z + 1);
		GL11.glEnd();
	}

	public static void addSurfaceCeiling(float x, float y, float z, Vector3f color) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x + 1, y, z);
		GL11.glVertex3f(x + 1, y, z + 1);
		GL11.glVertex3f(x, y, z + 1);
		GL11.glEnd();
	}

	public static void addTriangles(float x, float y, float z, Vector3f color) {
		GL11.glBegin(GL11.GL_TRIANGLES);

		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x+1, y, z);
		GL11.glVertex3f(x, y, z-1);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x, y, z-1);
		GL11.glColor3f(color.getX(), color.getY()-1, color.getZ()-1);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);
		GL11.glColor3f(color.getX()-1, color.getY()-1, color.getZ());
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x, y, z-1);
		GL11.glVertex3f(x, y, z);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ()-1);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glColor3f(color.getX()-1, color.getY()-1, color.getZ());
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x+1, y, z);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x+1, y, z);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ()-1);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);

		GL11.glEnd();
	}
	
	public static void addUniqueColorTriangles(float x, float y, float z, Vector3f color) {
		GL11.glBegin(GL11.GL_TRIANGLES);

		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x+1, y, z);
		GL11.glVertex3f(x, y, z-1);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x, y, z-1);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x, y, z-1);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);
		GL11.glVertex3f(x+1, y, z);
		GL11.glVertex3f(x+1, y, z-1);
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x+1, y, z);
		GL11.glVertex3f(x+0.5f, y + 1, z-0.5f);

		GL11.glEnd();
	}

	public static void addBlock(float x, float y, float z, Vector3f color) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(color.getX(), color.getY(), color.getZ());
		GL11.glVertex3f(x, y, z);
		GL11.glVertex3f(x + 1, y, z);
		GL11.glVertex3f(x + 1, y, z + 1);
		GL11.glVertex3f(x, y, z + 1);
		GL11.glEnd();
	}

}
