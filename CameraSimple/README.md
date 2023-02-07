# Simple Camera intent

<img src="./Screenshots/camera_demo.gif" width="300">

## Procedure:

1. Define `CAMERA`, `WRITE_EXTERNAL_STORAGE` permissions and camera feature in `Manifest`
2. Define `ImageView` and `Button` in layouts
3. Initiate runtime permissions for camera and external storage
4. Handle permissions with `onRequestPermissionsResult()`
5. Define `openCamera()` (camera intent) method
6. Set URI of `ImageView` resource  after successful return from Camera intent

For the detailed instructions, please follow [here](https://tbl-unist.github.io/tbl-edge/Mobile%20(Mon%20&%20Wed%2014%2030%20~%2016%2030)%20e2931664d0d9423e97b5abd18f4e5a3b/Week%202%20Android%20communication%20&%20sensors%20c0f6510fb97341c49d934d1659d40ae6/Building%20Camera%20intent%20417cdbae31774fa48f964040ad9a88d5.html)
