        // Set up the scene
        const scene = new THREE.Scene();

        // Create a camera
        const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
        camera.position.z = 5;

        // Create a renderer
        const renderer = new THREE.WebGLRenderer();
        renderer.setSize(window.innerWidth, window.innerHeight);

        // Append the renderer to the scene
        document.getElementById('scene').appendChild(renderer.domElement);

        // Create the Earth
        const geometry = new THREE.SphereGeometry(2, 32, 32);
        const texture = new THREE.TextureLoader().load('earth_texture.jpg'); // Replace with your texture URL
        const material = new THREE.MeshBasicMaterial({ map: texture });
        const earth = new THREE.Mesh(geometry, material);

        // Add the Earth to the scene
        scene.add(earth);

        // Add mouse interaction for rotating
        const controls = new THREE.OrbitControls(camera, renderer.domElement);

        // Create an animation loop
        const animate = () => {
            requestAnimationFrame(animate);

            // Rotate the Earth
            earth.rotation.y += 0.005;

            // Render the scene
            renderer.render(scene, camera);
        };

        animate();