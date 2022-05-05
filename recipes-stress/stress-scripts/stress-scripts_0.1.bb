SUMMARY = "Stress scripts used for burning MTK platforms"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://start.py \
           file://disk.py \
           file://runner.py"

S = "${WORKDIR}"

do_install() {
	install -d -m 0755 ${D}${ROOT_HOME}/stress_scripts
	install -m 0755 ${WORKDIR}/start.py ${D}${ROOT_HOME}/stress_scripts/start.py
	install -m 0644 ${WORKDIR}/disk.py ${D}${ROOT_HOME}/stress_scripts/disk.py
	install -m 0644 ${WORKDIR}/runner.py ${D}${ROOT_HOME}/stress_scripts/runner.py
}

RDEPENDS:${PN} = "iperf3 fio stress-ng glmark2 sysstat"

FILES:${PN} = " \
	${ROOT_HOME}/stress_scripts/start.py \
	${ROOT_HOME}/stress_scripts/disk.py \
	${ROOT_HOME}/stress_scripts/runner.py \
"

