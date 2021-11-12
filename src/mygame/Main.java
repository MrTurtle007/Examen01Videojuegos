package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author Mr.Turtle007
 */
public class Main extends SimpleApplication {
    //se crean los Spatial necesarios
    Spatial s_sol;
    Spatial s_mercurio;
    Spatial s_venus;
    Spatial s_tierra;
    Spatial s_marte;
    
    Boolean isAtached = false;
    
    //nodos a utilizar
    Node nodo_sol;
    Node nodo_mercurio;
    Node nodo_venus;
    Node nodo_tierra;
    Node nodo_marte;
    
    //Quaterniones para trabajar con ello 
    Quaternion QSol = new Quaternion().fromAngleAxis(FastMath.PI/2000, new Vector3f(0,0,1));//quaternion;
    Quaternion QMercurio = new Quaternion().fromAngleAxis(FastMath.PI/5000, new Vector3f(0,0,1));//quaternion;
    Quaternion QVenus = new Quaternion().fromAngleAxis(FastMath.PI/6000, new Vector3f(0,0,1));//quaternion;
    Quaternion QTierra = new Quaternion().fromAngleAxis(FastMath.PI/10000, new Vector3f(0,0,1));//quaternion;
    Quaternion QMarte = new Quaternion().fromAngleAxis(FastMath.PI/8000, new Vector3f(0,0,1));//quaternion;
    
    Quaternion QNodoSol = new Quaternion().fromAngleAxis(FastMath.PI/10000, new Vector3f(0,1,0));//quaternion;
    Quaternion QNodoSolMercurio = new Quaternion().fromAngleAxis(FastMath.PI/5000, new Vector3f(0,1,0));//quaternion;
    Quaternion QNodoSolVenus = new Quaternion().fromAngleAxis(FastMath.PI/6000, new Vector3f(0,1,0));//quaternion;
    Quaternion QNodoSolTierra = new Quaternion().fromAngleAxis(FastMath.PI/7000, new Vector3f(0,1,0));//quaternion;
    Quaternion QNodoSolMarte = new Quaternion().fromAngleAxis(FastMath.PI/8000, new Vector3f(0,1,0));//quaternion;
    
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        //Configuración para el sol
        Sphere sol = new Sphere(20,20,1.5f);
        Geometry sol_geom = new Geometry("sol", sol);
        Material sol_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        sol_mat.setTexture("ColorMap", assetManager.loadTexture("Textures/sol.jpg"));
        sol_geom.setMaterial(sol_mat);
        sol_geom.rotate(FastMath.DEG_TO_RAD*-80, 0, 0);
        
        //Configuración para mercurio
        Sphere mercurio = new Sphere(20,20,0.3f);
        Geometry mercurio_geom = new Geometry("mercurio", mercurio);
        Material mercurio_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mercurio_mat.setTexture("ColorMap", assetManager.loadTexture("Textures/mercurio.jpg"));
        mercurio_geom.setMaterial(mercurio_mat);
        mercurio_geom.rotate(FastMath.DEG_TO_RAD*-45, 0, 0);
        mercurio_geom.move(new Vector3f(4,0,1));
        
        //Configuración para venus
        Sphere venus = new Sphere(20,20,0.4f);
        Geometry venus_geom = new Geometry("venus", venus);
        Material venus_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        venus_mat.setTexture("ColorMap", assetManager.loadTexture("Textures/venus.jpg"));
        venus_geom.setMaterial(venus_mat);
        venus_geom.rotate(FastMath.DEG_TO_RAD*-45, 0, 0);
        venus_geom.move(new Vector3f(4,0,3));
        
        //Configuración para la tierra
        Sphere tierra = new Sphere(20,20,0.5f);
        Geometry tierra_geom = new Geometry("tierra", tierra);
        Material tierra_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        tierra_mat.setTexture("ColorMap", assetManager.loadTexture("Textures/tierra.jpg"));
        tierra_geom.setMaterial(tierra_mat);
        tierra_geom.rotate(FastMath.DEG_TO_RAD*-45, 0, 0);
        tierra_geom.move(new Vector3f(4,0,5));
        
        //Configuración para marte
        Sphere marte = new Sphere(20,20,0.4f);
        Geometry marte_geom = new Geometry("marte", marte);
        Material marte_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        marte_mat.setTexture("ColorMap", assetManager.loadTexture("Textures/marte.jpg"));
        marte_geom.setMaterial(marte_mat);
        marte_geom.rotate(FastMath.DEG_TO_RAD*-45, 0, 0);
        marte_geom.move(new Vector3f(4,0,7));
        
        //se asignan a los nodos correspondientes
        nodo_sol = new Node ("nodo_sol");
        nodo_mercurio = new Node ("nodo_mercurio");
        nodo_venus = new Node ("nodo_venus");
        nodo_tierra = new Node ("nodo_tierra");
        nodo_marte = new Node ("nodo_marte");
        
        //se crean las geometrias
        rootNode.attachChild(sol_geom);
        rootNode.attachChild(mercurio_geom);
        rootNode.attachChild(venus_geom);
        rootNode.attachChild(tierra_geom);
        rootNode.attachChild(marte_geom);
        
        //se configuran a sus correspondientes nodos
        rootNode.attachChild(nodo_sol);
        rootNode.attachChild(nodo_mercurio);
        rootNode.attachChild(nodo_venus);
        rootNode.attachChild(nodo_tierra);
        rootNode.attachChild(nodo_marte);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
        if(s_sol == null){
            s_sol = rootNode.getChild("sol");
        }
        if(s_mercurio == null) {
            s_mercurio = rootNode.getChild("mercurio");
        }
        if(s_venus == null) {
            s_venus = rootNode.getChild("venus");
        }
        if(s_tierra == null) {
            s_tierra = rootNode.getChild("tierra");
        }
        if(s_marte == null) {
            s_marte = rootNode.getChild("marte");
        }
        
        //se añade la configuración del quaternion para su rotacion sobre su eje
        s_sol.rotate(QSol);
        s_mercurio.rotate(QMercurio);
        s_venus.rotate(QVenus);
        s_tierra.rotate(QTierra);
        s_marte.rotate(QMarte);
        
        //se añade la configuración sobre las geometrias correspondientes
        nodo_mercurio.attachChild(s_mercurio);
        nodo_venus.attachChild(s_venus);
        nodo_tierra.attachChild(s_tierra);
        nodo_marte.attachChild(s_marte);
        
        //se añade la configuración del quaternion para su rotacion sobre el sol
        nodo_mercurio.rotate(QNodoSolMercurio);
        nodo_venus.rotate(QNodoSolVenus);
        nodo_tierra.rotate(QNodoSolTierra);
        nodo_marte.rotate(QNodoSolMarte);
    }
    
    public void transladar_luna(){
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
