import { useEffect, useRef } from 'react';
import gsap from 'gsap';

import { NavBar } from '../components/NavBar';
import './HomePage.scss';

export const HomePage = () => {

    const titleRef = useRef();

    useEffect(() => {

        gsap.from(titleRef.current, {
            scale: 0,
            opacity: 0,
            duration: 1,
            ease: "back.out(1.7)"
        });

    }, []);

    return ( <>
            <NavBar />
            <section className="hero">
                <div className="hero-content">
                    <h1 ref={titleRef} className="foody-title">
                        FOODY
                    </h1>
                    <p>
                        Skip The Queue. Order Smart.
                    </p>
                    <button>
                        Order Now
                    </button>
                </div>
            </section>
        </>
    );
};