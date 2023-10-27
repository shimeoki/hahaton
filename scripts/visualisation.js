        import * as THREE from '../node_modules/three/build/three.module.js';
        import { OrbitControls } from '../node_modules/three/examples/jsm/controls/OrbitControls.js';
        import { GLTFLoader } from '../node_modules/three/examples/jsm/loaders/GLTFLoader.js'


        function getCenterPoint(mesh) {
            var middle = new THREE.Vector3();
            var geometry = mesh.geometry;
        
            geometry.computeBoundingBox();
        
            middle.x = (geometry.boundingBox.max.x + geometry.boundingBox.min.x) / 2;
            middle.y = (geometry.boundingBox.max.y + geometry.boundingBox.min.y) / 2;
            middle.z = (geometry.boundingBox.max.z + geometry.boundingBox.min.z) / 2;
        
            mesh.localToWorld( middle );
            return middle;
        }


        const init = () => {
            const sizes = {
                width: window.innerWidth,
                height: window.innerHeight,
            };
        
            const scene = new THREE.Scene();
            const canvas = document.getElementById('scene');
            const camera = new THREE.PerspectiveCamera(75, sizes.width / sizes.height);
            scene.add(camera);
        
            const controls = new OrbitControls(camera, canvas);
            controls.enableDamping = true;
        
            const renderer = new THREE.WebGLRenderer({ canvas });
            renderer.setSize(sizes.width, sizes.height);
            renderer.render(scene, camera);
        
            return { sizes, scene, canvas, camera, renderer, controls };
        };
        
        const { sizes, camera, scene, canvas, controls, renderer } = init();
        
        camera.position.z = 2;

        const light = new THREE.AmbientLight( 0xffffff ); // soft white light
        scene.add( light );
        
        //draw earth
        const loader = new GLTFLoader()

        loader.load('../static/earth.gltf', (gltf) => {
            var earth = gltf.scene.children[0]
            scene.add(earth)
            var coords = getCenterPoint(earth);
            earth.position.setX(-coords.x)
            earth.position.setY(coords.y)
            earth.position.setZ(coords.z)
        })



        //draw ellipse
        const ovalShape = new THREE.Shape();
        ovalShape.ellipse(0, 0, 2, 1, 0, 2 * Math.PI);

        // Create a path geometry for the contour
        const geometry = new THREE.BufferGeometry().setFromPoints(ovalShape.getPoints());

        // Create a material for the contour (e.g., a basic line material)
        const material = new THREE.LineBasicMaterial({ color: 0x00ff00 });

        // Create a line using the geometry and material
        const contour = new THREE.Line(geometry, material);

        // Add the contour to the scene
        scene.add(contour);

        

        const tick = () => {
            controls.update();
            renderer.render(scene, camera);
            window.requestAnimationFrame(tick);
        };
        tick();
        
        /** Базовые обпаботчики событий длы поддержки ресайза */
        window.addEventListener('resize', () => {
            // Обновляем размеры
            sizes.width = window.innerWidth;
            sizes.height = window.innerHeight;
        
            // Обновляем соотношение сторон камеры
            camera.aspect = sizes.width / sizes.height;
            camera.updateProjectionMatrix();
        
            // Обновляем renderer
            renderer.setSize(sizes.width, sizes.height);
            renderer.setPixelRatio(Math.min(window.devicePixelRatio, 2));
            renderer.render(scene, camera);
        });
        
        // window.addEventListener('dblclick', () => {
        //     if (!document.fullscreenElement) {
        //         canvas.requestFullscreen();
        //     } else {
        //         document.exitFullscreen();
        //     }
        // });