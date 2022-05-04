# meta-stress-test

This layer is the collection of recipes used for running stress test for
variety of MediaTek platforms. The layer contains following:

* Scripts developed by MediaTek for running stress test according to
  defined scenario.
* Additional packages needed, but not included in default AIoT Linux
  configuration.

The layer has been verified on following platforms:

* i1200

## Dependencies

This layer depends on following layers:

* core
* [meta-rity](https://gitlab.com/mediatek/aiot/rity/meta-rity)

## How to use

Suppose that we have a RITY building environment, clone the repository under
`src` folder:

    git clone https://gitlab.com/mediatek/aiot/team-mtk-aiot-sw-ss2/meta-stress-test <RITY_PROJECT>/src/meta-stress-test

Run following command to add this layer to BitBake building environment

    bitbake-layers add-layer ../src/meta-stress-test

And follow the usual way to build image:

    bitbake rity-demo-image

The stress test mode will be enabled for the supported platform.

To disable stress test mode, remove the layer and rebuild the image:

    bitbake-layers remove-layer ../src/meta-stress-test
    bitbake rity-demo-image
