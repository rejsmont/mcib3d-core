/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcib3d.spatial.sampler;

import mcib3d.geom.Object3D;
import mcib3d.geom.Objects3DPopulation;
import mcib3d.image3d.ImageHandler;
import mcib3d.image3d.ImageShort;

/**
 *
 * @author thomasb
 */
public class SpatialRandom implements SpatialModel {

    private int nbObjects;
    private double distHardCore;// in pixels
    private Object3D mask;

    public SpatialRandom(int nbObjects, double distHardCore, Object3D mask) {
        this.nbObjects = nbObjects;
        this.distHardCore = distHardCore;
        this.mask = mask;
    }

    @Override
    public boolean init() {
        return true;
    }

    @Override
    public Objects3DPopulation getSample() {
        Objects3DPopulation pop = new Objects3DPopulation();
        pop.setMask(mask);
        pop.createRandomPopulation(nbObjects, distHardCore);

        return pop;
    }

    @Override
    public ImageHandler getSampleImage() {
        ImageHandler tmp = new ImageShort(getName(), mask.getXmax() + 1, mask.getYmax() + 1, mask.getZmax() + 1);
        getSample().draw(tmp);

        return tmp;
    }

    @Override
    public String getName() {
        return "Random Sampling";
    }

    public Object3D getMask() {
        return mask;
    }
    
    

}
