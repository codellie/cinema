
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReserveManager from "./components/listers/ReserveCards"
import ReserveDetail from "./components/listers/ReserveDetail"

import TicketManager from "./components/listers/TicketCards"
import TicketDetail from "./components/listers/TicketDetail"

import PointManager from "./components/listers/PointCards"
import PointDetail from "./components/listers/PointDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reserves',
                name: 'ReserveManager',
                component: ReserveManager
            },
            {
                path: '/reserves/:id',
                name: 'ReserveDetail',
                component: ReserveDetail
            },

            {
                path: '/tickets',
                name: 'TicketManager',
                component: TicketManager
            },
            {
                path: '/tickets/:id',
                name: 'TicketDetail',
                component: TicketDetail
            },

            {
                path: '/points',
                name: 'PointManager',
                component: PointManager
            },
            {
                path: '/points/:id',
                name: 'PointDetail',
                component: PointDetail
            },



    ]
})
