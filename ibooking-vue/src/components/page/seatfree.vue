<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 座位查询
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box"> <!-- 确保这个外层容器足够宽 -->
                <el-row>
                    <el-col span="11">
                        <div class="demo-input-suffix">
                            自习室号：
                            <el-input placeholder="请输入自习室号" prefix-icon="el-icon-search"
                                v-model="FreeSeatsearcher.rid"></el-input>
                        </div>
                    </el-col>
                    <el-col span="11">
                        <div class="demo-input-suffix">
                            开始时间：
                            <el-input placeholder="请输入开始时间" prefix-icon="el-icon-search"
                                v-model="FreeSeatsearcher.starttime"></el-input>
                        </div>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col span="11">
                        <div class="demo-input-suffix">
                            结束时间：
                            <el-input placeholder="请输入结束时间" prefix-icon="el-icon-search"
                                v-model="FreeSeatsearcher.endtime"></el-input>
                        </div>
                    </el-col>
                    <el-col span="11">
                        <div class="demo-input-suffix">
                            座位号：
                            <el-input placeholder="请输入座位号" prefix-icon="el-icon-search"
                                v-model="Appointmenter.sid"></el-input>
                        </div>
                    </el-col>
                </el-row>
            </div>


            <div class="demo-input-suffix">
                是否为当日：
                <el-radio-group v-model="FreeSeatsearcher.today">
                    <el-radio label="1">是</el-radio>
                    <el-radio label="0">否</el-radio>
                </el-radio-group>
            </div>
            
            <div style="height: 20px;"></div>

            <div class="button-container">
                <el-button type="primary" icon="el-icon-search" @click="getRoomSeat">查看自习室所有座位信息</el-button>
                <el-button type="primary" icon="el-icon-search" @click="lookforFreeSeat">查看指定时段空闲座位</el-button>
                <el-button type="primary" icon="el-icon-search" @click="get_SeatInfo">查看座位详细信息</el-button>
            </div>
        </div>
        <el-divider></el-divider>
        <el-table :data="seatInfo" border class="table" ref="multipleTable" header-cell-class-name="table-header">
            <!-- <el-table-column prop="id" label="座位自增id"></el-table-column> -->
            <el-table-column prop="zid" label="座位号"></el-table-column>
            <el-table-column prop="rid" label="自习室号"></el-table-column>
            <!-- <el-table-column prop="socket" label="是否有插座"></el-table-column> -->
            <el-table-column prop="osocket" label="是否有插座" align="center">
                <template slot-scope="scope">
                    <h1 v-if="scope.row.overnight == 1">
                        <div style="font-size:12px">
                            是
                        </div>
                    </h1>
                    <h1 v-else style="font-size:12px">
                        <div>
                            否
                        </div>
                    </h1>
                </template>
            </el-table-column>
            <!-- <el-table-column prop="today_book" label="当日预约信息"></el-table-column>
                <el-table-column prop="next_book" label="次日预约信息"></el-table-column> -->


            <el-table-column prop="today_book" label="今日预约" align="center" width="315">
                <template slot-scope="scope">
                    <el-row>
                        <el-col span="4" v-for="(book, index) in scope.row.today_book">
                            <el-button v-if="book == '0'" type="primary" size="mini" round>{{ index
                                }}:00</el-button>
                            <el-button v-else type="danger" size="mini" round>{{ index }}:00</el-button>
                        </el-col>
                    </el-row>
                </template>
            </el-table-column>

            <el-table-column prop="next_book" label="明日预约" align="center" width="315">
                <template slot-scope="scope">
                    <el-row>
                        <el-col span="4" v-for="(book, index) in scope.row.next_book">
                            <el-button v-if="book == '0'" type="primary" size="mini" round>{{ index
                                }}:00</el-button>
                            <el-button v-else type="danger" size="mini" round>{{ index }}:00</el-button>
                        </el-col>
                    </el-row>
                </template>
            </el-table-column>
        </el-table>


        <el-table-column label="操作" width="200" align="center">
            <template slot-scope="scope">
                <el-button type="text" icon="el-icon-search"
                    @click="handleAppointment(scope.$index, scope.row)">预定</el-button>
            </template>
        </el-table-column>
        </el-table>
    </div>

    <!-- <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="query" label-width="70px">
                <el-form-item label="学号">
                    <el-input v-model="query.sid"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="query.sname"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="query.password"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="query.email"></el-input>
                </el-form-item>
                <el-form-item label="电话">
                    <el-input v-model="query.phone"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog> -->

    </div>
</template>

<script>
import { getSeatInfo, getAllSeat, getSeatFree, seatAppointment } from '../../api/index';
export default {
    name: 'basetable',
    data() {
        return {
            FreeSeatsearcher: {
                rid: 1,
                starttime: 1,
                endtime: 2,
                today: 1//是否查询当天
            },
            SeatInfosearcher: {
                id: 1
            },
            Appointmenter: {
                id: 1,//座位自增id
                starttime: 1,
                endtime: 2,
                today: 1,
                sid: "183"
            },
            seatInfo: [
                {
                    id: 111,
                    zid: 222,
                    rid: 333,
                    socket: 1,
                    today_book: "111100001111000011110000",
                    next_book: "111100001111000011110000",
                },
                {
                    id: 111,
                    zid: 222,
                    rid: 333,
                    socket: 1,
                    today_book: "111100001111000011110000",
                    next_book: "111100001111000011110000",
                }
            ],
            query: {
                id: 111,
                zid: 222,
                rid: 333,
                socket: 1,
                today_book: "111100001111000011110000",
                next_book: "111100001111000011110000",
            },
            inserter: {
                id: 111,
                zid: 222,
                rid: 333,
                socket: 1,
                today_book: "111100001111000011110000",
                next_book: "111100001111000011110000",
            },
            tableData: [],
            seatData: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            resultVisible: false,
            seatVisible: false,
            pageTotal: 1,
            form: {},
            idx: -1,
            id: -1,
            editOrNot: 1,
            token: "user"
        };
    },
    created() {
        this.get_SeatInfo();
    },
    methods: {
        clearer() {
            this.query = this.inserter;
        },
        getRoomSeat() {
            //查询某自习室的所有座位信息
            this.rid = FreeSeatsearcher.rid;
            getAllSeat(this.rid), then(res => {
                this.seatInfo = res.data[0];
            });
        },
        get_SeatInfo() {
            //根据座位自增id查到座位
            getSeatInfo(this.id).then(res => {
                this.seatInfo.splice(0, 1, res.data);
            });
        },
        lookforFreeSeat() {
            //查询指定时段空闲座位
            getSeatFree(this.FreeSeatsearcher).then(res => {
                this.seatInfo = res.data[0];
            });
        },
        handleAppointment() {
            this.Appointmenter.sid = localStorage.getItem('local_sid');
            this.Appointmenter.id = this.SeatInfosearcher.id;
            this.Appointmenter.starttime = this.FreeSeatsearcher.starttime;
            this.Appointmenter.endtime = this.FreeSeatsearcher.endtime;
            this.Appointmenter.today = this.FreeSeatsearcher.today;
            console.log(this.Appointmenter);
            seatAppointment(this.Appointmenter).then(res => {
                this.$message.success('预定成功');
            })
        }

    }

}
</script>

<style>
.handle-box {
    font-family: 'Arial', sans-serif;
    /* 设置字体类型 */
    line-height: 1.5;
    /* 设置行间距 */
    
}

.handle-box .demo-input-suffix {
    margin-bottom: 20px;
    /* 设置元素之间的间距 */
}

.el-input {
    font-size: 14px;
    /* 设置输入框内的文字大小 */
}

.el-button {
    flex: 1;
    /* 让每个按钮填充等量的空间 */
}

.button-container {
    display: flex; /* 启用Flexbox布局 */
    justify-content: space-between; /* 按钮之间的空间均匀分布 */
    align-items: center; /* 垂直居中对齐子元素 */
} 

.el-col {
    margin: 0 8px;
    /* 每个按钮两侧增加8像素的间距 */
    margin-bottom: 10px;
    /* 每个按钮底部增加10像素的间距 */
}
</style>